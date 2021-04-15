package com.luv2code.springdemo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class TestDAO {
	public void logging(boolean isReady) {
		System.out.println("LOGGING TO THE CONSOLE...");
	}
}
