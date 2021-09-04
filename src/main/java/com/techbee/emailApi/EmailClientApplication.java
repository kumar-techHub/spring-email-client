package com.techbee.emailApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.techbee.emailApi.service.MailSenderService;

@SpringBootApplication
public class EmailClientApplication {

	@Autowired
	private MailSenderService mailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(EmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() {
		mailSenderService.sendSimpleEmail("fromEmail", "subject", "body", "toEmail");
	}

}
