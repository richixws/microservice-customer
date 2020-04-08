package com.example.Bancario.Bootcamp.demo.service;

import com.example.Bancario.Bootcamp.demo.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {

	//listar todo
	public Flux<Customer> findAll();
	
	//listar por id
	public Mono<Customer> findById(String id);
	
	//crear cliente
	public Mono<Customer> save(Customer customer);
	
	//actualizar
    public Mono<Customer> update(String id, Customer customer);

    //eliminar
    public Mono<Void> delete(Customer customer);

    //actualizar banco
    public Mono<Customer> updateBankById(String bank,String id);
    
   
    
    
}
