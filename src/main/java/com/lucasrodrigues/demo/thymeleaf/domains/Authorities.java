package com.lucasrodrigues.demo.thymeleaf.domains;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="authorities",uniqueConstraints = {@UniqueConstraint(columnNames = {"username","authority"})})
public class Authorities implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "username",length = 255)
	private String username;
	
	@JoinColumn(name = "username",insertable = false, updatable = false,foreignKey = @ForeignKey(name = "fk_authorities_users"),referencedColumnName = "username")
	@ManyToOne
	private Users users;
	
	@Column(name = "authority", length = 50, nullable = false)
	private String authority;
}
