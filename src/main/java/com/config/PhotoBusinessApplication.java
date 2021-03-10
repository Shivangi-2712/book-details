package com.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.controller")


public class PhotoBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoBusinessApplication.class, args);
	}

}

