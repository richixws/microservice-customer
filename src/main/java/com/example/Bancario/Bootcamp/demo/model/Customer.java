package com.example.Bancario.Bootcamp.demo.model;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@ToString
@Data
@Document(collection = "cliente")

public class Customer {
 
	@Id
	private String id;
	
	private String firsname;
	
	private String LastName;
	
	private String dni;

//	private CustomerType customerType;
	
	
	


	

	public String getFirsname() {
		return firsname;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirsname(String firsname) {
		this.firsname = firsname;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


//	public CustomerType getCustomerType() {
//		return customerType;
//	}


//	public void setCustomerType(CustomerType customerType) {
//		this.customerType = customerType;
//	}
	
	
	
	
	
	
	
}
