package com.dtits.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/get-form")
	public String getForm() {
		return "get-form";
	}
	
	@RequestMapping("/process-form")
	public String processForm() {
		return "process-form";
	}
	
//	@RequestMapping("/to-uppercase")
//	public String toUppercase(HttpServletRequest request, Model model) {
//		model.addAttribute("message", request.getParameter("studentName").toUpperCase());
//		
//		return "process-form";
//	}
	
	@RequestMapping("/to-uppercase")
	public String toUppercase(@RequestParam("studentName") String name, Model model) {
		model.addAttribute("message", name.toUpperCase());
		
		return "process-form";
	}
}
