package com.lucasrodrigues.demo.thymeleaf.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasrodrigues.demo.thymeleaf.domains.Product;
import com.lucasrodrigues.demo.thymeleaf.enums.ProductStatus;
import com.lucasrodrigues.demo.thymeleaf.service.ProductService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Profile("test")
public class ConfigTest implements CommandLineRunner {

	private final ProductService productService;
	
	@Override
	public void run(String... args) throws Exception {
		List<Product> listToSave = new ArrayList<>();
		listToSave.add(new Product(null,"Redmi Note 10S Pebble White 8 GB RAM 128 GB ROM",null,"https://m.media-amazon.com/images/I/511ouQ6FHvL._AC_SL1101_.jpg","https://shortest.link/1JOZ","",new BigDecimal("2000"),ProductStatus.PURCHASED));	
		listToSave.add(new Product(null,"iPhone XR Apple 64GB Branco",null,"https://www.casasbahia-imagens.com.br/Control/ArquivoExibir.aspx?IdArquivo=1469097804","https://shortest.link/1FqV"," Tela de 6.1”, Câmera de 12MP, iOS",new BigDecimal("3400"),ProductStatus.WAITING_APPROVAL));	
		productService.saveAll(listToSave);
	}

}
