package com.firstspring;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

import com.firstspring.model.PersonModel;

@EnableConfigurationProperties
@ComponentScan("com.firstspring")
@SpringBootApplication
public class FirstSpringApplication {
	
	@Bean(name = "username")
	@Profile("dev")
	public PersonModel giveMeDevPerson() {
		return new PersonModel("dev");
	}
	
	@Bean(name = "username")
	@Profile("prod")
	public PersonModel giveMeProdPerson() {
		return new PersonModel("prod");
	}

	public static void main(String[] args) {
		ApplicationContext ct = SpringApplication.run(FirstSpringApplication.class, args);
		String[] beanArray = ct.getBeanDefinitionNames();
		Arrays.sort(beanArray);
		for (String name : beanArray) {
			System.out.println(name);
		}
		System.out.println(ct.getBean("personModel"));
		System.out.println(ct.getBean("username"));
	}
}
