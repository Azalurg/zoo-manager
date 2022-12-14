package com.github.azalurg.zoomanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZooManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooManagerApplication.class, args);
	}

  @Bean
	public CommandLineRunner setUpApp() {
		return (args) -> {
		};
	}
}
