package com.learn.email.service;

import com.learn.email.entity.EmailParameters;

public interface Services {
	
//	Method to send simple email
	String sendSimpleEmail(EmailParameters parameters);
//	Method to send email with an attachment
	String sendAttachmentEmail(EmailParameters parameters);

}
