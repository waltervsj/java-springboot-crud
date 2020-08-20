package com.walter.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.walter.workshop.entities.Demand;
import com.walter.workshop.entities.User;
import com.walter.workshop.repositories.DemandRepository;
import com.walter.workshop.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DemandRepository demandRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Demand demand1 = new Demand(null, Instant.now(), u1);
		Demand demand2 = new Demand(null, Instant.now(), u2);
		Demand demand3 = new Demand(null, Instant.now(), u1);
		
		demandRepository.saveAll(Arrays.asList(demand1, demand2, demand3));
	}
}
