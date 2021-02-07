package com.immutestable.dvdrental.movies

import com.immutestable.dvdrental.movies.api.MoviesController
import org.springframework.beans.factory.annotation.Autowired

class MoviesITSpec extends IntegrationSpec {

    @Autowired
    private MoviesController controller;

    def "when context is loaded then all expected beans are created"() {
        expect: "the WebController is created"
        controller
    }

    def "Name"() {
        when:
        def rs = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)

        then:
        rs == "Hello, World"
    }
}
