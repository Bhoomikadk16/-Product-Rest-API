package org.oracle.product_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Product Rest API",description = "Rest api using spring boots for performing crud operations",version = "2.5.0",contact = @Contact(name = "Bhoomika",url = "https://www.wikipedia.com",email = "bhoomika@gmail.com")))
public class ProductApiApplication {
	public static void main(String[] args){
		SpringApplication.run(ProductApiApplication.class, args);
	}
}
