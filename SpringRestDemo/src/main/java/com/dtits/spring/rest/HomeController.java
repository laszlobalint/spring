package com.dtits.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class HomeController {
	
	@GetMapping("/welcome")
	public String welcome() {
		
		return "Welcome!";
	}
}
