package com.example.Bancario.Bootcamp.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Bancario.Bootcamp.demo.model.CustomerType;

import reactor.core.publisher.Mono;

@Repository
public interface ICustomerTypeRepository extends ReactiveMongoRepository<CustomerType, String> {

	Mono<CustomerType> findByCustomerTypeCode(Integer customertypecode);
}
