package com.faridroid.GraphQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class GraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

}
