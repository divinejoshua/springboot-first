package com.springbootfirst.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootfirst.model.UserModel;

@RestController
public class UserController {
	
	
//	User hash map 
	private Map<String, UserModel> userMap = new HashMap<>();

//	User Data 
	public UserController () {
		userMap.put("john", new UserModel("John", "Doe", 123));
		userMap.put("jane", new UserModel("Jane", "Doe", 234));
		userMap.put("jack", new UserModel("Jack", "Doe", 345));
		userMap.put("jil", new UserModel("Jil", "Doe", 456));
	}
	
//	Home page 
	@GetMapping("/")
	public String welcome() {
		
		return "Welcome to Divine's new project. This is Spring boot Java...";
		
	}
	
	
	
//	Get user details
	@GetMapping("/user/{username}")
	public ResponseEntity<UserModel> getuser(@PathVariable String username) {
		
		
		
//		Convert to lower case
		username = username.toLowerCase();
		
		
		
//		Check if user name exist 
		if(!userMap.containsKey(username)) {
			return ResponseEntity.notFound().build();
		}


//		Return the user 
		return ResponseEntity.of(Optional.of(userMap.get(username)));
		
	}
	
	
//	Add new user
	@PostMapping("/createuser")
	public ResponseEntity<HttpStatus> createuser(@RequestBody UserModel user) {
		
				
//		Convert the first name lower case and make it the user name
		String username = user.getFirstname().toLowerCase();
		
//		Create the user 
		userMap.put(username, user);
		
		return ResponseEntity.ok().build();
		
	}
	
	
	
//	Delete user
	@DeleteMapping("/deleteuser/{username}")
	public ResponseEntity<HttpStatus> deleteuser(@PathVariable String username) {
		
				
//		Convert user name to lower case
		username = username.toLowerCase();
		
//		Create the user 
		userMap.remove(username);
		
		return ResponseEntity.noContent().build();
		
	}


}
