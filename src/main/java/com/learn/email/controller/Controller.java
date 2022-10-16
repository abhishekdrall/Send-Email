package com.learn.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.email.entity.EmailParameters;
import com.learn.email.service.Services;


@RestController
public class Controller {
	@Autowired 
	private Services services;
	 
    // Sending a simple Email
    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailParameters parameters)
    {
        String status= services.sendSimpleEmail(parameters);
         return status;
    }
 
    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
        @RequestBody EmailParameters parameters)
    {
        String status= services.sendAttachmentEmail(parameters);
         return status;
    }
}

