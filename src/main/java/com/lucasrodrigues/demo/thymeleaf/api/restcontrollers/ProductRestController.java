package com.lucasrodrigues.demo.thymeleaf.api.restcontrollers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;
import com.lucasrodrigues.demo.thymeleaf.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductRestController {

	
	private final ProductService productService;
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Product>> getProductsByStatus(@PathVariable("status") String status, HttpServletRequest request){
		PageRequest pageable = PageRequest.of(0, 10, Sort.by("deliveryDate").descending());
		ProductStatus productSatus = ProductStatus.valueOf(status.toUpperCase());
		return ResponseEntity.ok().body(productService.findByStatus(productSatus,pageable));

	}
}
