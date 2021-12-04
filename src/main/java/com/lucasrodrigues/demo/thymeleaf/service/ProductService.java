package com.lucasrodrigues.demo.thymeleaf.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.domains.Users;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;
import com.lucasrodrigues.demo.thymeleaf.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

	private final ProductRepository repository;
	
	private final UsersService	usersService;
	
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
		
		
		if(entity == null)
			throw new RuntimeException("product is null");
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = findByUserById(userName);
		entity.setUsers(users);
		
		if(entity.getUsers() == null || StringUtils.hasLength(entity.getUserId()))
			throw new RuntimeException("no user associated with the product");
		repository.save(entity);
	}

	public List<Product> findByStatus(ProductStatus productSatus, String userId) {
		return repository.findByStatusAndUserId(productSatus,userId);
	}
	
	public Users findByUserById(String userId) {
		return usersService.findById(userId);
	}
	
	public List<Product> findByUserId(String userId) {
		return repository.findByUserId(userId);
	}
}
