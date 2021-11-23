package com.lucasrodrigues.demo.thymeleaf.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="authorities",uniqueConstraints = {@UniqueConstraint(columnNames = {"username","authority"})})
public class Authorities implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "username",foreignKey = @ForeignKey(name = "fk_authorities_users"),referencedColumnName = "username")
	@ManyToOne
	private Users users;
	
	@Column(name = "authority", length = 50, nullable = false)
	private String authority;
}
