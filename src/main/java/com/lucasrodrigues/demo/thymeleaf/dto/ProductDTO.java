package com.lucasrodrigues.demo.thymeleaf.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.util.StringUtils;

import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.domains.Users;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	
	private UUID id;
	
	
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
	
	private String userId;
	
	private Users user;
	
	public Product toProduct() {
		return new Product(id, name, getFullDeliveryDate(), urlImage, urlProduct, description, value, status,userId,user);
	}
	
	public LocalDateTime getFullDeliveryDate() {
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		if (StringUtils.hasLength(deliveryDate))
			return LocalDateTime.parse(deliveryDate+" 23:59",formater);
		else
			return null;
	}
}
