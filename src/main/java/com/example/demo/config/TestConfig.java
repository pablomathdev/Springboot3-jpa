package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
	@Autowired
	private UserRepository userRepository;
    
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null,"Batman", "batmancav@gmail.com","123456");
		User u2 = new User(null,"Superman", "superman@gmail.com","123456");
		
		
		Order o1 = new Order(null,Instant.parse("2023-03-21T11:11:07Z"),u1);
		Order o2 = new Order(null,Instant.parse("2023-03-21T10:09:07Z"),u2);
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2));
	}
	
	
}
