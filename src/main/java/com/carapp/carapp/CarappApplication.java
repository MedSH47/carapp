package com.carapp.carapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class CarappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarappApplication.class, args);
	}

}
