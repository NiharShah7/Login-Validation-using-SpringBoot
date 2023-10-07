package com.instagram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	
	@Autowired
	private UserService us;
	
	@GetMapping("user/{username}/{password}")
	public int userlogin(@PathVariable("username") String username1 , @PathVariable ("password") String password1 ) {
		
		int flag=us.loginValidation(username1, password1);
		
		if(flag==0) {
			return 0;
		}
			
		return flag;
	} 
	
}
