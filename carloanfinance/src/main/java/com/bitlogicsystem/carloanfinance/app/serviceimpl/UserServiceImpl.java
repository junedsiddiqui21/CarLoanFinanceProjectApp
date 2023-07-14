package com.bitlogicsystem.carloanfinance.app.serviceimpl;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.model.User;
import com.bitlogicsystem.carloanfinance.app.repository.UserRepository;
import com.bitlogicsystem.carloanfinance.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	JavaMailSender sender;
	
	@Override
	public User saveUserData(User a) {
		// TODO Auto-generated method stub
		
		Random random = new Random();	
		int x = random.nextInt(500);
		String username = a.getUName()+x;
		a.setUsername(username);
		
		String subject = "User Login Details"; 
		
		String text = "Your username : "+a.getUsername()+" \n "+"password : "+a.getPassword();		
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(a.getFromEmail());
		message.setCc(a.getUserEmail());
		message.setSubject(subject);
		message.setText(text);
		
		sender.send(message);
		
		return userRepository.save(a);
	}

	@Override
	public User getUserData(String username, String password) {
		
		return userRepository.findByUsernameAndPassword(username,password);
	}

	

}
