package com.example.tododemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(path = "/",method = RequestMethod.GET)
	public String goToWelcomeJSP(ModelMap model) {
		model.put("user", getLoggedInUsername());
		return "welcome";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
