package com.lucasrodrigues.demo.thymeleaf.api.restcontrollers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.dto.ProductDTO;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;
import com.lucasrodrigues.demo.thymeleaf.service.ProductService;

@RestController
@RequestMapping("/api/offers")
public class OffersRestController {

	
	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<Product> save(Model model,@Valid ProductDTO productDTO,Principal principal,BindingResult result) {
		if(result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		Product product = productService.findById(productDTO.getId());
		if(product.getId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		product.setDeliveryDate(productDTO.getFullDeliveryDate());
		product.setValue(productDTO.getValue());
		product.setStatus(ProductStatus.WANTED);
		
		return ResponseEntity.ok().body(productService.save(productDTO.toProduct()));
		
	}
}
