package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
@Configuration
public class DBConnections {
	@Profile("dev")
	@Bean
	public String devDBConn() {
		System.out.println("devcoonection");

		return "devthu";

	}
	@Profile("prod")
	@Bean
	public String productionDBConn() {
		System.out.println("Prodcoonection");

		return "prodthu";

	}
}
