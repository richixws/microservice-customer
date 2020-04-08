package com.example.Bancario.Bootcamp.demo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.Bancario.Bootcamp.demo.model.Customer;
import com.example.Bancario.Bootcamp.demo.service.ICustomerService;

import io.swagger.models.Response;
import reactor.core.publisher.Mono;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest(classes = DemoApplicationTests.class)
class DemoApplicationTests {

	@Autowired
	private WebTestClient client;
	
	@Autowired
	private ICustomerService customerservice;
	
	
	@Test
	void listarClientesTest() {
		
		client.get()
		.uri("/customer/listar")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBodyList(Customer.class)
		.consumeWith(response->{
		  List<Customer> customer=response.getResponseBody();
		    customer.forEach(c->{
		    	System.out.println(c);
		    });
		   Assertions.assertThat(customer.size()>0).isTrue();
		});
	}
	


}
