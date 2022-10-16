package com.learn.email.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.learn.email.entity.EmailParameters;

@Service
public class ServiceImpl implements Services{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	@Override
	public String sendSimpleEmail(EmailParameters parameters) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(sender);
        mailMessage.setTo(parameters.getReciever_email());
        mailMessage.setText(parameters.getEmail_body());
        mailMessage.setSubject(parameters.getEmail_subject());
		
        javaMailSender.send(mailMessage);
        return "Mail Sent Successfully...";
	}

	@Override
	public String sendAttachmentEmail(EmailParameters parameters) {
		{
	        // Creating a mime message
	        MimeMessage mimeMessage
	            = javaMailSender.createMimeMessage();
	        MimeMessageHelper mimeMessageHelper;
	 
	        try {
	 
	            // Setting multipart as true for attachments to
	            // be send
	            mimeMessageHelper
	                = new MimeMessageHelper(mimeMessage, true);
	            mimeMessageHelper.setFrom(sender);
	            mimeMessageHelper.setTo(parameters.getReciever_email());
	            mimeMessageHelper.setText(parameters.getEmail_body());
	            mimeMessageHelper.setSubject(parameters.getEmail_subject());
	 
	            // Adding the attachment
	            FileSystemResource file= new FileSystemResource(new File(parameters.getEmail_attachment()));
	 
	            mimeMessageHelper.addAttachment(file.getFilename(), file);
	            
	            // Sending the mail
	            javaMailSender.send(mimeMessage);
	            return "Mail sent Successfully";
	        	} catch (MessagingException e) {
	        		 
	                // Display message when exception occurred
	                return "Error while sending mail!!!";
	            }

			}
	}
}
