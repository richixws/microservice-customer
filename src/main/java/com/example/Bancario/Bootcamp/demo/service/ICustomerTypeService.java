package com.example.Bancario.Bootcamp.demo.service;

import com.example.Bancario.Bootcamp.demo.model.Customer;
import com.example.Bancario.Bootcamp.demo.model.CustomerType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerTypeService {
	
	
	Mono<CustomerType> save(CustomerType customerType);
	Mono<Void> delete(String id);
	Mono<CustomerType> findById(String id);
	Flux<CustomerType> findAll();
	
	Mono<CustomerType> buscarPorCodigoTipoCliente(Integer customertypecode);
 
}
