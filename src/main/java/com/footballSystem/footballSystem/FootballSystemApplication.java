package com.footballSystem.footballSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class FootballSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballSystemApplication.class, args);
	}

}
