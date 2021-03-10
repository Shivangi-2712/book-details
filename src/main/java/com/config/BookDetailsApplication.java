package com.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.controller")


public class BookDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookDetailsApplication.class, args);
	}

}

