package com.example.Bancario.Bootcamp.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bancario.Bootcamp.demo.model.Customer;
import com.example.Bancario.Bootcamp.demo.repository.ICustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerrepository;

	@Override
	public Mono<Customer> save(Customer customer) {

		if (customer.getJoinAt() == null) {
			customer.setJoinAt(new Date());
		} else {
			customer.setJoinAt(customer.getJoinAt());
		}

		return this.customerrepository.save(customer);
	}

	@Override
	public Mono<Void> delete(Customer customer) {
		// TODO Auto-generated method stub
		return this.customerrepository.delete(customer);
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

	@Override
	public Mono<Customer> updateBankById(String bank, String id) {

		return customerrepository.findById(id).flatMap(c -> {

			if (c.getBank() == null) {
				c.setBank(c.getBank());
			} else {
				c.setBank(bank);
			}

			return customerrepository.save(c);

		});
	}

}
