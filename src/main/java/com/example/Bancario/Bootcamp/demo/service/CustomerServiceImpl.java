package com.example.Bancario.Bootcamp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bancario.Bootcamp.demo.model.Customer;
import com.example.Bancario.Bootcamp.demo.repository.ICustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ICustomerRepository customerrepository;

	@Override
	public Mono<Customer> save(Customer costumer) {
		// TODO Auto-generated method stub
		return this.customerrepository.save(costumer);
	}

	@Override
	public Mono<Customer> delete(String id) {
		// TODO Auto-generated method stub
		return this.customerrepository.findById(id)
				.flatMap(p -> this.customerrepository.deleteById(p.getId()).thenReturn(p));
	}

	@Override
	public Mono<Customer> update(String id, Customer customer) {
		return this.customerrepository.findById(id).flatMap(cust -> {
			customer.setId(id);
			return save(customer);

		}).switchIfEmpty(Mono.empty());
	}

	@Override
	public Flux<Customer> findAll() {
		// TODO Auto-generated method stub
		return this.customerrepository.findAll();
	}

	@Override
	public Mono<Customer> findById(String id) {
		// TODO Auto-generated method stub
		return this.customerrepository.findById(id);
	}

}
