package com.example.Bancario.Bootcamp.demo.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Bancario.Bootcamp.demo.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ICustomerRepository extends ReactiveMongoRepository<Customer, String> {

	public Mono<Customer> findByNombre(String nombre);
//	Flux<Customer> findByCustomer(Integer Customer);
	
	
}
 