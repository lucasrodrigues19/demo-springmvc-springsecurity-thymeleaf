package com.lucasrodrigues.demo.thymeleaf.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "username", length = 255, nullable = false)
	private String username;
	
	@Column(name = "password", length = 500, nullable = false)
	private String password;
	
	@Column(name = "enabled",  nullable = false)
	private boolean enabled;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "users", fetch = FetchType.LAZY)
	private List<Product> listProducts = new ArrayList<>();
}
