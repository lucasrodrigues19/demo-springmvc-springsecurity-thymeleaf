package com.lucasrodrigues.demo.thymeleaf.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lucasrodrigues.demo.thymeleaf.ProductRepository;
import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

	private final ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(UUID id){
		return repository.findById(id).orElse(new Product());
	}
	
	public void saveAll(List<Product> listToSave) {
		if(!CollectionUtils.isEmpty(listToSave))
			repository.saveAll(listToSave);
	}
	
	public void save(Product entity) {
		repository.save(entity);
	}

	public List<Product> findByStatus(ProductStatus productSatus) {
		return repository.findByStatus(productSatus);
	}
}
