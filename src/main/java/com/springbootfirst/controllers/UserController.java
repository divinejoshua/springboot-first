package com.springbootfirst.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
//	Home page 
	@GetMapping("/")
	public String welcome() {
		
		return "Welcome to Divine's new project. This is Spring boot Java...";
		
	}
	
	
//	Get user details
	@GetMapping("/user")
	public String getuser() {
		
		return "Get user";
		
	}

}
