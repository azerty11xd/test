package com.dari.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DariApplication {

	public static void main(String[] args) {
		SpringApplication.run(DariApplication.class, args);
	}

}
