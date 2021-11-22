package com.lucasrodrigues.demo.thymeleaf.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resourse not found. Id "+ id);
	}
}
