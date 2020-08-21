package com.walter.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.walter.workshop.entities.Category;
import com.walter.workshop.entities.Demand;
import com.walter.workshop.entities.DemandItem;
import com.walter.workshop.entities.Product;
import com.walter.workshop.entities.User;
import com.walter.workshop.entities.enums.DemandStatus;
import com.walter.workshop.repositories.CategoryRepository;
import com.walter.workshop.repositories.DemandItemRepository;
import com.walter.workshop.repositories.DemandRepository;
import com.walter.workshop.repositories.ProductRepository;
import com.walter.workshop.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DemandRepository demandRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private DemandItemRepository demandItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Demand demand1 = new Demand(null, Instant.now(), DemandStatus.PAID, u1);
		Demand demand2 = new Demand(null, Instant.now(), DemandStatus.WAITING_PAYMENT, u2);
		Demand demand3 = new Demand(null, Instant.now(), DemandStatus.CANCELED, u1);
		
		demandRepository.saveAll(Arrays.asList(demand1, demand2, demand3));
		
		Category category1 = new Category(null, "Eletronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
	
		p1.getCategories().add(category2);
		p2.getCategories().add(category1);
		p2.getCategories().add(category3);
		p3.getCategories().add(category3);
		p4.getCategories().add(category3);
		p5.getCategories().add(category2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		DemandItem oi1 = new DemandItem(demand1, p1, 2, p1.getPrice());
		DemandItem oi2 = new DemandItem(demand1, p3, 1, p3.getPrice());
		DemandItem oi3 = new DemandItem(demand2, p3, 2, p3.getPrice());
		DemandItem oi4 = new DemandItem(demand3, p5, 2, p5.getPrice()); 

		demandItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}
}
