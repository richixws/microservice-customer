package com.example.Bancario.Bootcamp.demo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bancario.Bootcamp.demo.model.CustomerType;
import com.example.Bancario.Bootcamp.demo.service.ICustomerTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customertype")
@Api(value = "cipo de cliente")
public class CustomerTypeController {
	
	@Autowired
	private ICustomerTypeService customerTypeService;
	
	@PostMapping("/save")
	@ResponseStatus
	private Mono<CustomerType> save(@RequestBody CustomerType customerType){
		
		 return this.customerTypeService.save(customerType);
	}
	
	@GetMapping("/findAll")
	private Flux<CustomerType> findAll(){
		
		return this.customerTypeService.findAll();
		
	}
	@GetMapping("/findById/{id}")
	private Mono<CustomerType> findById(@PathVariable String id){
		
		return this.customerTypeService.findById(id);
	}
	@GetMapping("/delete/{id}")
	private Mono<Void> delete(@PathVariable String id){
		
		return this.customerTypeService.delete(id);
	}
	
}
