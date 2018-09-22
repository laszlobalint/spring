package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/stories")
	public String stories() {
		return "stories";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}
}