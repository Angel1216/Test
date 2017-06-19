package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mx.com.anzen.repository.SPRepository;

@SpringBootApplication
public class TestApiSpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApiSpApplication.class, args);
	}
	
	// Se habilita el Bean del SessionFactory para
		// realizar la inyección de dependencia en el repositorio 
		@Bean
	    public SPRepository entityManager() {
	        return new SPRepository();
	    }
}
