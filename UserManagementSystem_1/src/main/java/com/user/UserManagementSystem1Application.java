package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserManagementSystem1Application {

	public static void main(String[] args) {
//		SpringApplication.run(UserManagementSystem1Application.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(UserManagementSystem1Application.class);
		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
	}

}
