package com.example.Bancario.Bootcamp.demo.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

public class CustomerType {

	@Id
	private int idCustomerType;
	
	@NotEmpty
	private String descripcion;
	
	
	public CustomerType(int idCustomerType, String descripcion) {
		super();
		this.idCustomerType = idCustomerType;
		this.descripcion = descripcion;
	}
	
	
	
	
	
}
