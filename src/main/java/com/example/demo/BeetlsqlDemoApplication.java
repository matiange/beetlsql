package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class BeetlsqlDemoApplication {

	public static void main(String[] args) {
		System.out.println();
		SpringApplication.run(BeetlsqlDemoApplication.class, args);
	}

}
