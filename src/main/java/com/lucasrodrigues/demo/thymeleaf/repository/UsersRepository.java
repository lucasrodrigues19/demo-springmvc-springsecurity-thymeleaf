package com.lucasrodrigues.demo.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasrodrigues.demo.thymeleaf.domains.Users;

public interface UsersRepository extends JpaRepository<Users, String>{

}
