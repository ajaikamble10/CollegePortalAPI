package com.clg_portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CollegePortalApiApplication {

	public static void main(String[] args) {
		System.out.println("Welcome To College Portal");
		ApplicationContext context = SpringApplication.run(CollegePortalApiApplication.class, args);
	}

}