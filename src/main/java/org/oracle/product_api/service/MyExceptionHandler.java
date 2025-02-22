package org.oracle.product_api.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
//import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//@RestControllerAdvice
@OpenAPIDefinition(info=@Info(title = "REST API",description  = "Performing crud operation using Rest API",version = "2.3.4"))

public class MyExceptionHandler {
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<Object> handle(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("error", "Url is Incorrect");
		return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handler(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("error", "Enter proper value");
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> handler1(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("error", "Check the Method");
		return new ResponseEntity<Object>(map,HttpStatus.METHOD_NOT_ALLOWED);
	}
}
