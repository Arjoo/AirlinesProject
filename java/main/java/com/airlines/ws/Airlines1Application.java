package com.airlines.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.airlines.ws.model.UserCredential;

@SpringBootApplication
@ComponentScan(basePackages = {"com.airlines"})
@EntityScan(basePackageClasses=UserCredential.class)
public class Airlines1Application {

	public static void main(String[] args) {
		SpringApplication.run(Airlines1Application.class, args);
		System.out.println("Your application start now !!");
	}
}
