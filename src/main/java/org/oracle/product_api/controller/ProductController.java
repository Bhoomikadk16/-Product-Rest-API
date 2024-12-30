package org.oracle.product_api.controller;

import java.util.List;

import org.oracle.product_api.dto.Product;
import org.oracle.product_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	//Saving Single Product
	@Operation(description = "Saving oen product",summary = "Saving Single Product")
	@PostMapping("/products")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product){
		return service.saveProduct(product);
	}
	
	//Save Multiple Products
	@PostMapping("/products/many")
	@Operation(summary = "Save Multiple Products")
	public ResponseEntity<Object> saveProducts(@RequestBody List<Product> products){
		return service.saveProducts(products);
	}
	
	//Fetch All Products
	@Operation(summary = "Fetch All Products")
	@GetMapping("/products")
	public ResponseEntity<Object> fetchAllProducts(){
		return service.fetchAllProducts();
	}
	
	//Fetch Product By Id
	@Operation(summary = "Fetch Product By Id")
	@GetMapping("/products/{id}")
	public ResponseEntity<Object> fetchById(@PathVariable int id){
		return service.fetchById(id);
	}
	
	//Fetch Product By Name
	@Operation(summary = "Fetch Product By Name")
	@GetMapping("/products/name/{name}")
	public ResponseEntity<Object> fetchByName(@PathVariable String name){
		return service.fetchByName(name);
	}
	
	//Fetch Products Price Greater Than
	@Operation(summary = "Fetch Products Price Greater Than")
	@GetMapping("/products/price/greater/{price}")
	public ResponseEntity<Object> fetchByPriceGreater(@PathVariable double price){
		return service.fetchByPriceGreater(price);
	}
	
	//Fetch Products By Stock Between
	@Operation(summary = "Fetch Products By Stock Between")
	@GetMapping("/products/stock/{min}/{max}")
	public ResponseEntity<Object> fetchByStockBetween(@PathVariable int min,@PathVariable int max){
		return service.fetchByStockBetween(min,max);
	}
	
//	//Fetch Products By less than  some price
//	@GetMapping("/products/price/lesser/{amt}")
//	public ResponseEntity<Object> fetchByPriceLesser(@PathVariable int amt){
//		return service.fetchByPriceLesser(amt);
//	}
	
	//Deleting products by id
	@Operation(summary = "Deleting products by id")
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	//Update records put
	@Operation(summary = "Update records PUT")
	@PutMapping("/products")
	public ResponseEntity<Object> updateRcord(@RequestBody Product product){
		return service.updateProduct(product);
	}
	
	//Update records patch
	@Operation(summary = "Update records PATCH")
	@PatchMapping("/products/{id}")
	public ResponseEntity<Object> updateRcord(@PathVariable int id,@RequestBody Product product){
		return service.updateProduct(id,product);
	}
}

