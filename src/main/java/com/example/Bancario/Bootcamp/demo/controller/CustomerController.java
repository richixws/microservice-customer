package com.example.Bancario.Bootcamp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bancario.Bootcamp.demo.model.Customer;
import com.example.Bancario.Bootcamp.demo.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
@Api(value = "sistema gestion clientes")
public class CustomerController {


	@Autowired
	private CustomerService customerservice;
	
	@ApiOperation(value = "registrar cliente")
	@PostMapping("/customer")
	@ResponseStatus
	private Mono<Customer> save(@RequestBody Customer customer){
		
		return this.customerservice.save(customer);
		
	}
	
	@ApiOperation(value = "listado clientes")
	@GetMapping("/listar")
	private Flux<Customer> findAll(){
		
		return this.customerservice.findAll();
	}
	
	@ApiOperation(value = "cliente buscado ")
	@GetMapping("/listar/{id}")
	private Mono<Customer> findById(@PathVariable String id){
     
	 Mono<Customer> cust=customerservice.findById(id)	;			
     return cust;
	
	}
	@ApiOperation(value = "cliente actualizado")
	@PutMapping("/{id}")
	private Mono<Customer> update(@PathVariable String id,  @RequestBody Customer customer){
		
	  return customerservice.update(id, customer);
	}
	
	@ApiOperation(value = "cliente eliminado")
	@DeleteMapping("/{id}")
	private Mono<Customer> delete(@PathVariable String id){
	
		return customerservice.delete(id);
		
	}
	
}
