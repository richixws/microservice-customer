package com.example.Bancario.Bootcamp.demo.service;

import com.example.Bancario.Bootcamp.demo.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

	
	Mono<Customer> save(Customer costumer);

    Mono<Customer> delete(String id);

    Mono<Customer> update(String id, Customer costumer);

    Flux<Customer> findAll();

    Mono<Customer> findById(String id);
    
   
    
    
}
