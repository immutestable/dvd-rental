package com.immutestable.dvdrental.movies;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class DvdRentalApplicationTests  { // TODO remove?

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
		Assert.assertNotNull(testRestTemplate);
	}
}
