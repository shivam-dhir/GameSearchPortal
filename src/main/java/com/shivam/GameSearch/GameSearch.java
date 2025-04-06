package com.shivam.GameSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.shivam")
@EnableMongoRepositories(basePackages = "com.shivam.repository")
public class GameSearch {

	public static void main(String[] args) {
		SpringApplication.run(GameSearch.class, args);
	}

}
