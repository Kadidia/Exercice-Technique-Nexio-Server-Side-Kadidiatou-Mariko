package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExerciceJavaNexioApiTestsIntegrationTest {
	
	 @Autowired
	 private TestRestTemplate restTemplate;
	 
	 
	 @Test
	 public void createProduct() {
	        ResponseEntity<Product> responseEntity =
	        restTemplate.postForEntity("/addProduct", new Product(5,"micro-onde","39,99$"), Product.class);

	        Product product = responseEntity.getBody();
	        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	        assertEquals("micro-onde", product.getNom());
	 }
}
