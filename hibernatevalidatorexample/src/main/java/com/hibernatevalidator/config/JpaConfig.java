package com.hibernatevalidator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.hibernatevalidator.repository")
public class JpaConfig {

}