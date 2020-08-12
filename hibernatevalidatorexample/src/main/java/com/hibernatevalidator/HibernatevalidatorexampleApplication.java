package com.hibernatevalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
@EntityScan("com.hibernatevalidator.entity")
public class HibernatevalidatorexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatevalidatorexampleApplication.class, args);
	}

}
