package com.lucasrodrigues.demo.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {

	@GetMapping
	public String offers() {
		return "/forms/api/form-offers";
	}
}
