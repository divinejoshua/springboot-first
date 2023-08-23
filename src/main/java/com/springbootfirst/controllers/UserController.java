package com.springbootfirst.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootfirst.model.UserModel;

@RestController
public class UserController {
	
	
//	User hash map 
	private Map<String, UserModel> userMap = new HashMap<>();
	
	
//	Home page 
	@GetMapping("/")
	public String welcome() {
		
		return "Welcome to Divine's new project. This is Spring boot Java...";
		
	}
	
	
//	Get user details
	@GetMapping("/user")
	public UserModel getuser() {
		
		return new UserModel("John", "Doe", 123);
		
	}

}
