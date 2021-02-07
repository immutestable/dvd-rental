package com.immutestable.dvdrental.movies;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest
class DvdRentalApplicationTests  { // TODO remove?

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
		Assert.assertNotNull(testRestTemplate);
	}

}
