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
		model.addAttribute("listProduct", productService.findByStatus(ProductStatus.DELIVERED));
		model.addAttribute("status",ProductStatus.DELIVERED);
		return "home";

	}
	
}
