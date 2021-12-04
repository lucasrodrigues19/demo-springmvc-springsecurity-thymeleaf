package com.lucasrodrigues.demo.thymeleaf.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lucasrodrigues.demo.thymeleaf.domains.Authorities;
import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;
import com.lucasrodrigues.demo.thymeleaf.repository.AuthoritiesRepository;
import com.lucasrodrigues.demo.thymeleaf.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthoritiesService {

	private final AuthoritiesRepository repository;
	
	public List<Authorities> findAll(){
		return repository.findAll();
	}
	
	public Authorities findById(UUID  id){
		return repository.findById(id).orElse(new Authorities());
	}
	
	public void saveAll(List<Authorities> listToSave) {
		if(!CollectionUtils.isEmpty(listToSave))
			repository.saveAll(listToSave);
	}
	
	public void save(Authorities entity) {
		repository.save(entity);
	}

	public List<Authorities> findByUsername(String username) {
		return repository.findByUsername(username);
	}
	
}
