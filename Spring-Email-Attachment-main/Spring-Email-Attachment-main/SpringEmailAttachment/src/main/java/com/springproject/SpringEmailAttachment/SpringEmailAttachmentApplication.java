package com.springproject.SpringEmailAttachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class SpringEmailAttachmentApplication {

	
	@Autowired
	private EmailSenderService emailSenderService;
	public static void main(String[] args) {
		SpringApplication.run(SpringEmailAttachmentApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() throws MessagingException {
		emailSenderService.sendMailWithAttachment("saurabhandhaleit@sitrc.org",
				"This is body","This is Email With Attachment ", 
				"D:/Placement/Java Developer/Prashant Gawali_24_J.pdf");
	}
}
