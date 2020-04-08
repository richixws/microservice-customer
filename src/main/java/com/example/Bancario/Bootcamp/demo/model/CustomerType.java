package com.example.Bancario.Bootcamp.demo.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
public class CustomerType {

	@Id
	private String idCustomerType;
	
	@NotEmpty
	private String descripcion;

		
}
