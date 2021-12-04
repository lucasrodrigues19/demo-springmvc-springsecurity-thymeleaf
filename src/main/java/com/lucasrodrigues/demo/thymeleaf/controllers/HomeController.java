package com.lucasrodrigues.demo.thymeleaf.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lucasrodrigues.demo.thymeleaf.dto.ProductDTO;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;
import com.lucasrodrigues.demo.thymeleaf.service.ProductService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/home")
public class HomeController {

	private final ProductService productService;
	
	
	@GetMapping
	public String home(Model model, HttpServletRequest request, Principal principal) {
		model.addAttribute("listProduct", productService.findByUserId(principal.getName()));
		return "home";
	}
	

	@GetMapping("/status/{status}")
	public String findByStatus(@PathVariable("status")String status, Model model, HttpServletRequest request,Principal principal) {
		ProductStatus productSatus = ProductStatus.valueOf(status.toUpperCase());
		model.addAttribute("listProduct", productService.findByStatus(productSatus,principal.getName()));
		model.addAttribute("status",productSatus);
		return "home";
	}
	
	
}
