package com.Admin.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.Admin.Service.EmailService;

@Service("emailService")
public class DefaultEmailService implements EmailService {

	@Autowired
	private MailSender mailSender;

	@Override
	public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(fromAddress);
		mail.setTo(toAddress);
		mail.setSubject(subject);
		mail.setText(msgBody);
		mailSender.send(mail);
	}

}
