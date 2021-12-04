package com.lucasrodrigues.demo.thymeleaf.scurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private EncoderConfig encoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/resources/**", "/static/**","/webjars/**","/h2-console/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home", true).permitAll())
		.logout(logout -> logout.logoutUrl("/logout"))
		;
		
		  http.csrf().disable();
	        http.headers().frameOptions().disable();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//password authentication encript
		
		//para ultilizar o user, precisa criar uma tabela padrão do spring security para o user
		UserDetails user =
				 User.builder()
					.username("system")
					.password(encoder.encode("123"))
					.roles("ADMIN")
					.build();
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		//authentication default schema error when using PostgreSQL, default schema is not suitable for PostgreSQ 
		//.usersByUsernameQuery("select username,password, enabled from users where username=?")
		//.authoritiesByUsernameQuery("select username, role from tbauthorities where username=?")
		//
		.passwordEncoder(encoder.encoder())
		.withUser(user);
	}
	
	
	
	/**
	 * Usar apenas para testes, não recomendado usar este metodo em prd
	 * salva o usuario em memoria
	 */
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("system")
//				.password("123")
//				.roles("ADMIN")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
}
