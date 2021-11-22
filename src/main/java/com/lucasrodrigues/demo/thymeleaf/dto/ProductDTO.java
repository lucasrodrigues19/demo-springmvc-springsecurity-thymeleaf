package com.lucasrodrigues.demo.thymeleaf.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;

import lombok.Data;

@Data
public class ProductDTO {

	@NotBlank//Verificar a mensagem padrão para colocar no properties
	private String name;
	
	private String deliveryDate;
	
	@NotBlank
	private String urlImage;
	
	@NotBlank
	private String urlProduct;
	
	private String description;
	
	@Min(value = 0)
	private BigDecimal value;
	
	private ProductStatus status;
	
	public Product toProduct() {
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return new Product(null, name, LocalDateTime.parse(deliveryDate+" 23:59",formater), urlImage, urlProduct, description, value, status);
	}
}
