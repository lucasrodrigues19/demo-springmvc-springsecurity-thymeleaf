package com.lucasrodrigues.demo.thymeleaf.domains;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "username", length = 255, nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", length = 500, nullable = false)
	private String password;
	
	@Column(name = "enabled",  nullable = false)
	private boolean enabled;
}
