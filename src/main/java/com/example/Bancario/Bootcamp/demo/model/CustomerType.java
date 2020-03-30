package com.example.Bancario.Bootcamp.demo.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Data
@Getter
@Setter
@Document(collection = "tipocliente")
public class CustomerType {

	@Id
	private String idCustomerType;
	
	@NotEmpty
	private String descripcion;
	

	
	public CustomerType(@NotEmpty String descripcion) {
		this.descripcion = descripcion;
	}

		
}
