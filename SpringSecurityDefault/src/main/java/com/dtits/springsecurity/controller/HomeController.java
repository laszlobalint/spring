package com.dtits.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	
	@GetMapping("/leaders")
	public String leaders() {
		
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String systems() {
		
		return "systems";
	}
}
