package com.footballSystem.footballSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class FootballSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FootballSystemApplication.class, args);
	}




	@Override
	public void run(String... args) throws Exception {

	}
}
