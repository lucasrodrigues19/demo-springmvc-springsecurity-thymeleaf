package com.lucasrodrigues.demo.thymeleaf.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasrodrigues.demo.thymeleaf.domains.Authorities;
import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.dto.ProductDTO;
import com.lucasrodrigues.demo.thymeleaf.dto.UsersDTO;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;
import com.lucasrodrigues.demo.thymeleaf.service.AuthoritiesService;
import com.lucasrodrigues.demo.thymeleaf.service.ProductService;
import com.lucasrodrigues.demo.thymeleaf.service.UsersService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Profile("test")
public class ConfigTest implements CommandLineRunner {

	private final ProductService productService;
	
	private final UsersService usersService;
	
	private final AuthoritiesService authoritiesService;
	@Override
	public void run(String... args) throws Exception {
	
		UsersDTO user1 = new UsersDTO();
		user1.setUsername("lucas");
		user1.setPassword("www.");
		user1.setEnabled(true);
		usersService.save(user1.toUser());
		
		Authorities auth = new Authorities(user1.getUsername(),user1.toUser(), "ROLE_ADMIN");
		authoritiesService.save(auth);
		
		List<Product> listToSave = new ArrayList<>();
		listToSave.add(new ProductDTO("Redmi Note 10S Pebble White 8 GB RAM 128 GB ROM","12/12/2021","https://m.media-amazon.com/images/I/511ouQ6FHvL._AC_SL1101_.jpg","https://shortest.link/1JOZ","",new BigDecimal("2000"),ProductStatus.PURCHASED,user1.getUsername(),user1.toUser()).toProduct());	
		listToSave.add(new ProductDTO("iPhone XR Apple 64GB Branco","30/12/2021","https://www.casasbahia-imagens.com.br/Control/ArquivoExibir.aspx?IdArquivo=1469097804","https://shortest.link/1FqV"," Tela de 6.1”, Câmera de 12MP, iOS",new BigDecimal("3400"),ProductStatus.WAITING_APPROVAL,user1.getUsername(),user1.toUser()).toProduct());	
		productService.saveAll(listToSave);
	}

}
