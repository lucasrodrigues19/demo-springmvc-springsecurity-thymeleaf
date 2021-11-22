package com.lucasrodrigues.demo.thymeleaf.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class HandleExceptionController {

	@ExceptionHandler(IllegalArgumentException.class)
	public String illegalArgumentException() {
		return "redirect:/home";
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public String notFoundException() {
		return "redirect:/home";
	}
}
