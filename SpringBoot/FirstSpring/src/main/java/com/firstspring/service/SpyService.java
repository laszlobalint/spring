package com.firstspring.service;

import org.springframework.stereotype.Service;

@Service("spying")
public class SpyService {
	
	public String sayingSomething() {
		return "I am a spy!";
	}
}
