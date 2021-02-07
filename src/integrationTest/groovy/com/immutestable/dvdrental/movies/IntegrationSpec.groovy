package com.immutestable.dvdrental.movies

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*

@SpringBootTest(webEnvironment = RANDOM_PORT)
//@RunWith(SpringRunner.class)
class IntegrationSpec extends Specification {

    @LocalServerPort
    protected int port;

    @Autowired
    protected TestRestTemplate restTemplate;
}
