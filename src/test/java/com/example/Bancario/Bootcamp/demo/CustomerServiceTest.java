package com.example.Bancario.Bootcamp.demo;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.Bancario.Bootcamp.demo.model.Customer;
import com.example.Bancario.Bootcamp.demo.service.ICustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = 	SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerServiceTest {

	@Autowired
	private WebTestClient client;
	
	@Autowired
	private ICustomerService customerService;
	
	@Test
	void findAllCustomerTest() {
		
		client.get()
		.uri("/customers/findAll")
		.accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBodyList(Customer.class)
		.consumeWith(res -> {
			
				List<Customer> customer=res.getResponseBody();
				  customer.forEach(c ->{
					  System.out.println(c.getFirstName());
			
				  });
				  
			Assertions.assertThat(customer.size()>0).isTrue();
			
		});
		
	}
	
	
	

	
}
