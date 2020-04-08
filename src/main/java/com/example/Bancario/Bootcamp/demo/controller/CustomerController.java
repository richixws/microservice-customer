package com.example.Bancario.Bootcamp.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.example.Bancario.Bootcamp.demo.service.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
@Api(value = "sistema gestion clientes")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	//LISTAR TODOS LOS CLIENTES
		@GetMapping("/findAll")
		public Flux<Customer> findAll(){
			return service.findAll();
		}
		
		//LISTAR UN CLIENTE POR SU ID
		@GetMapping("/findById/{id}")
		public Mono<Customer> findById(@PathVariable("id") String id){
			return service.findById(id);
		}
		
		//CREAR UN CLIENTE
		@PostMapping("/create")
		public Mono<ResponseEntity<Customer>> create(@RequestBody Customer cus){
			return service.save(cus).map(c -> ResponseEntity.created(URI.create("/clients".concat(c.getId())))
					.contentType(MediaType.APPLICATION_JSON).body(c));
		}
		
		//ACTUALIZAR UN CLIENTE
		@PutMapping("/update/{id}")
		public Mono<ResponseEntity<Customer>> update(@PathVariable("id") String id, @RequestBody Customer cus){
			return service.update(id, cus)
					.map(c -> ResponseEntity.created(URI.create("/clients".concat(c.getId())))
							.contentType(MediaType.APPLICATION_JSON).body(c))
					.defaultIfEmpty(ResponseEntity.notFound().build());
		}
		
		//ELIMINAR UN CLIENTE
		@DeleteMapping("/delete/{id}")
		public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
			return service.findById(id)
					.flatMap(c -> {
						return service.delete(c)
								.then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
					}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
		}
		
		//ACTUALIZAR EL BANCO
		@PutMapping("/updateBank/{id}")
		public Mono<ResponseEntity<Customer>> updateBankById(@PathVariable("id") String id, @RequestBody Customer cus){
			return service.updateBankById(cus.getBank(), id)
					.map(c -> ResponseEntity.created(URI.create("/clients".concat(c.getId())))
							.contentType(MediaType.APPLICATION_JSON).body(c))
					.defaultIfEmpty(ResponseEntity.notFound().build());
		}
		
	
}
