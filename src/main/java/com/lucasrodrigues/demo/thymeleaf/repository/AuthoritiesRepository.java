package com.lucasrodrigues.demo.thymeleaf.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasrodrigues.demo.thymeleaf.domains.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, UUID>{

	List<Authorities> findByUsername(String username);

}
