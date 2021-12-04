package com.lucasrodrigues.demo.thymeleaf.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.domains.Users;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;
import com.lucasrodrigues.demo.thymeleaf.repository.UsersRepository;
import com.lucasrodrigues.demo.thymeleaf.scurity.config.EncoderConfig;

import lombok.AllArgsConstructor;

@Service("usersService")
public class UsersService {

	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private  ProductService productService;
	
	public List<Users> findAll(){
		return repository.findAll();
	}
	
	public Users findById(String id){
		return repository.findById(id).orElse(null);
	}
	
	@Transactional(rollbackOn = RuntimeException.class)
	public void saveAll(List<Users> listToSave) {
		if(CollectionUtils.isEmpty(listToSave))
			return;
		
		for(Users entity: listToSave) {
			entity.setPassword(entity.getPassword());
			repository.save(entity);
		}
	}
	
	@Transactional(rollbackOn = RuntimeException.class)
	public void save(Users entity) {
		if(entity == null)
			return;
		repository.save(entity);
	}
	
	public List<Product> getProductByUserId(String userId){
		return productService.findByUserId(userId);
	}

	public List<Product> getProductByStatusAndUserId(ProductStatus productSatus, String userId) {
		return productService.findByStatusAndUserId(productSatus, userId);
	}

}
