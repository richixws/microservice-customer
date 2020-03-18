package com.example.Bancario.Bootcamp.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	//@Value("${com.bootcamp.gateway.url}")
	//private String gatewayUrlPort;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
