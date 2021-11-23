package com.lucasrodrigues.demo.thymeleaf.scurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/resources/**", "/static/**","/webjars/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin(form -> form.loginPage("/login").permitAll())
		.logout(logout -> logout.logoutUrl("/logout"));
		
	}
	
	
	
	/**
	 * Usar apenas para testes, não recomendado usar este metodo em prd
	 */
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("system")
				.password("123")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
