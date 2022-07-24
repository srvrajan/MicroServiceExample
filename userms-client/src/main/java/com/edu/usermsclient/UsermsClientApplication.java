package com.edu.usermsclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class UsermsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermsClientApplication.class, args);
	}

}
