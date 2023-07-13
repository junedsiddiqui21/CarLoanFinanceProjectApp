package com.bitlogicsystem.carloanfinance.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitlogicsystem.carloanfinance.app.model.Admin;
import com.bitlogicsystem.carloanfinance.app.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	AdminService as;
	
	@Value("${spring.mail.username}")
	String fromEmail;
	
	@PostMapping("/saveAdmin")
	public String sendAdminData(@RequestBody Admin admin)
	{
		
		admin.setFromEmail(fromEmail);
		try {
			as.saveAdminData(admin);
		} catch (Exception e2) {
			System.out.println(e2);
			return "Email cannot be send";
		}
		return "Email sent Successfully";	
	}
		
}
