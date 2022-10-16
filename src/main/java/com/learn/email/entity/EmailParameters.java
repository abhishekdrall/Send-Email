package com.learn.email.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailParameters {
	private final String email_subject="Email project";
	private final String email_body="Hello, This email is being sent to check whether the project is working or not";
	private String reciever_email;
	private String email_attachment;
}
