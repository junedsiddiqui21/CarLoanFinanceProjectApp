package com.bitlogicsystem.carloanfinance.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitlogicsystem.carloanfinance.app.model.User;
import com.bitlogicsystem.carloanfinance.app.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService user;
	
	@Value("${spring.mail.username}")
	String fromEmail;
	
	@PostMapping("/save")
	public String sendUserData(@RequestBody User admin)
	{
		
		admin.setFromEmail(fromEmail);
		try {
			user.saveUserData(admin);
		} catch (Exception e2) {
			System.out.println(e2);
			return "Email cannot be send";
		}
		return "Email sent Successfully";	
	}
	
	
	@GetMapping("/get/{username}/{password}")
	public User getUserData(@PathVariable String username,@PathVariable String password)
	{
		return user.getUserData(username,password);
	}
	
		
}
