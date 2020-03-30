package com.example.Bancario.Bootcamp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bancario.Bootcamp.demo.model.CustomerType;
import com.example.Bancario.Bootcamp.demo.repository.ICustomerTypeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerTypeServiceImpl  implements ICustomerTypeService{

	@Autowired
	private ICustomerTypeRepository customertyperepository;
	
	@Override
	public Mono<CustomerType> save(CustomerType customerType) {
		// TODO Auto-generated method stub
		return this.customertyperepository.save(customerType);
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return this.customertyperepository.deleteById(id);
	}

	@Override
	public Mono<CustomerType> findById(String id) {
		// TODO Auto-generated method stub
		return this.customertyperepository.findById(id);
	}

	@Override
	public Flux<CustomerType> findAll() {
		// TODO Auto-generated method stub
		return this.customertyperepository.findAll();
	}

	@Override
	public Mono<CustomerType> buscarPorCodigoTipoCliente(Integer customertypecode) {
		// TODO Auto-generated method stub
		return customertyperepository.findByCustomerTypeCode(customertypecode);
	}
	
	

}
