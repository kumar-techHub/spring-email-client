package com.techbee.emailApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendSimpleEmail(String fromEmail, String body, String subject, String toEmail) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(toEmail);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		mailMessage.setFrom(fromEmail);		
		javaMailSender.send(mailMessage);
	}
}
