package com.immutestable.dvdrental.users

import com.immutestable.dvdrental.IntegrationSpec
import com.immutestable.dvdrental.users.domain.User
import org.springframework.core.ParameterizedTypeReference
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.http.*

import static org.springframework.http.MediaType.APPLICATION_JSON

class UsersITSpec extends IntegrationSpec {

    def name = "Greg"
    def surname = "Ridiculous"

    def "Creates user"() {
        given:
        def requestBody = serialize(User.builder().firstName(name).lastName(surname).build())
        def headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(requestBody, headers);

        when:
        def rs = this.restTemplate.postForEntity(forPath("/users"), request, EntityModel.class)

        then:
        rs.statusCode == HttpStatus.CREATED
        def newEntityID = getEntityID(rs.body)
        def createdUser = this.restTemplate.getForEntity(forPath("/users/${newEntityID}"), User.class)
        with(createdUser.body) {
            it.firstName == name
            it.lastName == surname
        }
    }

    def "user is searchable by name"() {
        given:
        createUser(name, surname)
        createUser("June", surname)

        when:
        def usersFound = this.restTemplate.exchange(forPath("/users/search/findByLastName?name=${surname}"), HttpMethod.GET, null, new ParameterizedTypeReference<CollectionModel<User>>() {
        })

        then:
        usersFound.statusCode == HttpStatus.OK
        usersFound.body.content.size() == 2
        usersFound.body.content.contains(newUser(name, surname))
        usersFound.body.content.contains(newUser("June", surname))
    }


    private ResponseEntity<User> createUser(String name, String surname) {
        def requestBody = serialize(newUser(name, surname))
        def headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(requestBody, headers);
        return this.restTemplate.postForEntity(forPath("/users"), request, User.class)
    }


    private User newUser(String name, String surname) {
        return User.builder().firstName(name).lastName(surname).build()
    }
}
