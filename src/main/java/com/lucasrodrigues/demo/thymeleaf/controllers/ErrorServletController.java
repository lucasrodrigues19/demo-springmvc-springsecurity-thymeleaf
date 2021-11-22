package com.lucasrodrigues.demo.thymeleaf.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorServletController{
   
	
	@GetMapping("/404")
	public String error404() {
		return "/error/404";
	}
	
	@GetMapping("/403")
	public String error403() {
		return "/error/404";
	}
}
