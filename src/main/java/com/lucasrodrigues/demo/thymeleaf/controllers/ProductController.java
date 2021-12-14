package com.lucasrodrigues.demo.thymeleaf.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucasrodrigues.demo.thymeleaf.domains.Users;
import com.lucasrodrigues.demo.thymeleaf.dto.ProductDTO;
import com.lucasrodrigues.demo.thymeleaf.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/create")
	public String create(Model model, HttpServletRequest request) {
		model.addAttribute("productDTO",new ProductDTO());
		return "/forms/form-product";
	}
	
	@PostMapping("/save")
	public String save(Model model,@Valid ProductDTO productDTO,Principal principal,BindingResult result) {
		if(result.hasErrors()) {
			return "/forms/form-product";
		}
		
		productService.save(productDTO.toProduct());
		model.addAttribute("listProduct",productService.findAll());
		return "redirect:/user/products";
	}
}
