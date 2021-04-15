package com.luv2code.springdemo.service;

import java.util.concurrent.TimeUnit;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
	
	@Override
	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		return "This is your luck day!";
	}
}
