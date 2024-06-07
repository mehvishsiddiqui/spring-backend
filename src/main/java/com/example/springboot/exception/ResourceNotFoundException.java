package com.example.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	/**
	 * *serialVersionUID is a unique identifier used during Java object serialization to ensure compatibility between different 
	 * versions of a class.
	 * It helps prevent issues when serializing and deserializing objects across different versions of an application.
	 */
	private static final long serialVersionUID =1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'",resourceName , fieldName,fieldValue ));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public Object getFieldValue(){
		return fieldValue;
	}
	
}
