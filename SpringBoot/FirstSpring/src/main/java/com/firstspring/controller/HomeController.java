package com.firstspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstspring.service.SpyService;

@RestController
public class HomeController {
	
	private SpyService spyService;
	
	@Value("${HomeController.msg}")
	private String message;
	
	@Autowired
	public void setSpyService(SpyService spyService) {
		this.spyService = spyService;
	}
	
	@RequestMapping("/")
	public String index() {
		return spyService.sayingSomething() + " " + message;
	}
}
