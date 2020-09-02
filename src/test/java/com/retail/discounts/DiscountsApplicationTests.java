package com.retail.discounts;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.retail.discounts.constants.Constants;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class DiscountsApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	private URI uri;

	@Before
	public void setUp() throws URISyntaxException {
		uri = new URI(Constants.VERSION_1 + Constants.RETAIL);

	}

	@Test
	void contextLoads() {
	}

	public void healthCheck() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri + "/health", String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
