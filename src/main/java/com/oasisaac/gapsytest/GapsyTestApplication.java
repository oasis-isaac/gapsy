package com.oasisaac.gapsytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GapsyTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GapsyTestApplication.class, args);
	}
}
