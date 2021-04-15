package com.dtits.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/denied")
	public String denied() {
		
		return "denied";
	}
}
