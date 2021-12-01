package com.lucasrodrigues.demo.thymeleaf.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.domains.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {

	@NotBlank(message = "id is not null")
	private String username;
	
	@NotBlank(message = "password is not null")
	private String password;
	
	private boolean enabled;
	
	private List<Product> listProducts = new ArrayList<>();
	
	public void setPassword(String password) {
		if(!StringUtils.hasLength(password))
			throw new RuntimeException("password is not null");

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password =  encoder.encode(password);
		
	}
	
	public Users toUser() {
		return new Users(username, password, enabled, listProducts);
	}
}
