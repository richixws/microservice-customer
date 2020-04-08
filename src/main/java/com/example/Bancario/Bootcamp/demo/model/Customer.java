package com.example.Bancario.Bootcamp.demo.model;

import java.util.Date;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Data
@Document(collection = "customers")

public class Customer {

	@Id
	private String id;

	private String fullname;

	private String numDoc;
	
	private String address;
	
	private String bank;
	 
    private String type;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date joinAt;


	
}
