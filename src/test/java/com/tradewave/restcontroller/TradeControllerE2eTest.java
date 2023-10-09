package com.tradewave.restcontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tradewave.business.Price;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class TradeControllerE2eTest {

	private String baseUrl = "http://localhost:3000/fmts/trades";
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testGetPricesWithValidCategory() {
	    String url = baseUrl + "/api/prices/STOCK";
	    ResponseEntity<Price[]> response = restTemplate.getForEntity(url, Price[].class);

	    // Assert the response status code and content as needed
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertNotNull(response.getBody());
	    // Add more assertions as necessary
	}

	@Test
	public void testGetPricesWithoutCategory() {
	    String url = baseUrl + "/api/prices/";
	    ResponseEntity<Price[]> response = restTemplate.getForEntity(url, Price[].class);

	    // Assert the response status code and content as needed
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertNotNull(response.getBody());
	    // Add more assertions to validate that no category was provided
	}

	@Test
	public void testGetPricesWithInvalidCategory() {
	    String url = baseUrl + "/api/prices/INVALID_CATEGORY";
	    ResponseEntity<Price[]> response = restTemplate.getForEntity(url, Price[].class);

	    // Assert the response status code and content as needed
	    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode()); 
	    // Add more assertions to validate the error response
	}
}
