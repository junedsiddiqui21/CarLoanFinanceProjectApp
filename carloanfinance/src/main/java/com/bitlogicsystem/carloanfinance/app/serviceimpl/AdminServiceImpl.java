package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.model.Admin;
import com.bitlogicsystem.carloanfinance.app.repository.AdminRepository;
import com.bitlogicsystem.carloanfinance.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository ar;
	
	@Autowired
	JavaMailSender sender;
	
	@Override
	public Admin saveAdminData(Admin a) {
		// TODO Auto-generated method stub
		
		String subject = "Admin Login Details"; 
		
		String text = "Your username "+a.getUsername()+"  "+"password "+a.getPassword();		
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(a.getFromEmail());
		message.setCc(a.getToEmail());
		message.setSubject(subject);
		message.setText(text);
		
		sender.send(message);
		return ar.save(a);
	}

	

}
