package com.project.luis_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LuisServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuisServerApplication.class, args);
	}

}
