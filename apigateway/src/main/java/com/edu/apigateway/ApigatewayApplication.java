package com.edu.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.function.Predicate;

@SpringBootApplication
public class ApigatewayApplication {

	public static void main(String[] args) {
		Optional.of("abc").filter(new Predicate<String>() {
			@Override
			public boolean test(String s) {
				return true;
			}
		}).get();
		SpringApplication.run(ApigatewayApplication.class, args);
	}

}
