package com.springproject.SpringEmailAttachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;




@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException {
		
		MimeMessage myMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper myMessageHelper=new MimeMessageHelper(myMessage, true);
		
		myMessageHelper.setFrom("prashant01aws@gmail.com");
		myMessageHelper.setTo(toEmail);
		myMessageHelper.setText(body);
		myMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource=new FileSystemResource(new String(attachment));
		myMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		javaMailSender.send(myMessage);
		
		System.out.println("Mail Send Successfully");
	}
}
