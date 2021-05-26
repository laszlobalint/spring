package com.dtits.springsecurity.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dtits.springsecurity.entity.User;
import com.dtits.springsecurity.service.UserService;
import com.dtits.springsecurity.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
    @Autowired
    private UserService userService;
	
    private Logger logger = Logger.getLogger(getClass().getName());
    
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/show-form")
	public String showMyLoginPage(Model model) {
		model.addAttribute("crmUser", new CrmUser());
		
		return "registration-form";
	}

	@PostMapping("/process-registration")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser crmUser, BindingResult bindingResult, Model model) {
		
		String userName = crmUser.getUsername();
		logger.info("Processing registration form for the user: " + userName);
		
		 if (bindingResult.hasErrors()) {
			 
			 return "registration-form";
		 }

        User existing = userService.findByUserName(userName);
        if (existing != null) {
        	model.addAttribute("crmUser", new CrmUser());
        	model.addAttribute("registrationError", "User name already exists.");
			logger.warning("User name already exists.");
			
        	return "registration-form";
        }
               						
        userService.save(crmUser);
        logger.info("Successfully created user: " + userName);
        
        return "registration-confirmation";		
	}
}
