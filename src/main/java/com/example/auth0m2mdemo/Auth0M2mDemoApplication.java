package com.example.auth0m2mdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Auth0M2mDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Auth0M2mDemoApplication.class, args);
	}

}
