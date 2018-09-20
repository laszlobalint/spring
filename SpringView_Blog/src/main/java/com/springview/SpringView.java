package com.springview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springview")
public class SpringView {

	public static void main(String[] args) {
		SpringApplication.run(SpringView.class, args);
	}
}