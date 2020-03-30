package com.example.Bancario.Bootcamp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.example.Bancario.Bootcamp.demo.model.Customer;
import com.example.Bancario.Bootcamp.demo.model.CustomerType;
import com.example.Bancario.Bootcamp.demo.repository.ICustomerRepository;
import com.example.Bancario.Bootcamp.demo.repository.ICustomerTypeRepository;

import reactor.core.publisher.Flux;


@EnableEurekaClient
@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	//@Value("${com.bootcamp.gateway.url}")
	//private String gatewayUrlPort;
	
	  @Autowired
	  private ReactiveMongoTemplate template;
	  
	  @Autowired
	  private ICustomerTypeRepository customerTypeRepository;
	  
	  @Autowired
	  private ICustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		  
//	 template.dropCollection(Customer.class).subscribe();
//	 template.dropCollection(CustomerType.class).subscribe();
	 
	 //registo de tipo de cliente
	 CustomerType ct1=new CustomerType("Empresarial");
	 CustomerType ct2=new CustomerType("personal");
	 CustomerType ct3=new CustomerType("pyme");
	 CustomerType ct4=new CustomerType("corporativo");
	 
	 Flux.just(ct1,ct2,ct3,ct4)
	 .flatMap(tip -> customerTypeRepository.save(tip))
	 .thenMany(Flux.just(new Customer("richard","andre","48345850", ct1),
			                new Customer("luis", "murao","48345850", ct2),
			                new Customer("lucho", "ramos", "42443432", ct3),
			                new Customer("maria", "ramos", "56323236", ct4))
	  .flatMap(customer -> {
		       return customerRepository.save(customer);
	  })).subscribe();
	
	}	
	

}
