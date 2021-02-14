package com.immutestable.dvdrental

import com.fasterxml.jackson.databind.ObjectMapper
import com.immutestable.dvdrental.infrastructure.TestMongoConfig
import com.immutestable.dvdrental.users.domain.User
import com.mongodb.client.MongoCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.MongoCollectionUtils
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.hateoas.EntityModel
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import static org.springframework.http.MediaType.APPLICATION_JSON

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Import(TestMongoConfig.class)
class IntegrationSpec extends Specification {

    @LocalServerPort
    protected int port;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper

    @Autowired
    TestMongoConfig config

    void setupSpec() {
    }

    String forPath(String path) {
        return "http://localhost:" + port + path
    }

    String serialize(Object object) {
        return objectMapper.writeValueAsString(object)
    }

    @SuppressWarnings("all")
    String getEntityID(EntityModel entityModel) {
        return entityModel.getLink("self").map(it -> it.href.split("/").last()).orElseThrow()
    }

    void setup() {
        config.mongoTemplate().collectionNames.forEach(collectionName ->
                config.mongoTemplate().dropCollection(collectionName)
        )
    }

    protected <T> ResponseEntity<T> genericResource(String path, Class<T> targetClass) { // TODO?
        def requestBody = serialize(User.builder().firstName(name).lastName(surname).build())
        def headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(requestBody, headers);
        return this.restTemplate.postForEntity(forPath(path), request, targetClass)
    }
}
