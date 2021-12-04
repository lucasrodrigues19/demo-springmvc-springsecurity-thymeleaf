package com.lucasrodrigues.demo.thymeleaf.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;
import com.lucasrodrigues.demo.thymeleaf.service.ProductService;
import com.lucasrodrigues.demo.thymeleaf.service.UsersService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsersController {

	private final UsersService usersService;
	
	@GetMapping("/products")
	public String home(Model model, HttpServletRequest request, Principal principal) {
		model.addAttribute("listProduct", usersService.getProductByUserId(principal.getName()));
		return "/homes/home-user";
	}
	

	@GetMapping("products/status/{status}")
	public String findByStatus(@PathVariable("status")String status, Model model, HttpServletRequest request,Principal principal) {
		ProductStatus productSatus = ProductStatus.valueOf(status.toUpperCase());
		model.addAttribute("listProduct", usersService.getProductByStatusAndUserId(productSatus,principal.getName()));
		model.addAttribute("status",productSatus);
		return "/homes/home-user";
	}
}
