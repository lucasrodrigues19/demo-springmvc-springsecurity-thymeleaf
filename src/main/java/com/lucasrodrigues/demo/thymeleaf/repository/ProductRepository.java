package com.lucasrodrigues.demo.thymeleaf.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;

public interface ProductRepository extends JpaRepository<Product, UUID>{

	List<Product> findByStatusAndUserId(ProductStatus productSatus, String userId);
	
	List<Product> findByUserId(String userId);

}
