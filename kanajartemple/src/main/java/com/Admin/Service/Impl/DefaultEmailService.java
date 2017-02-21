package com.Admin.Service.Impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.Admin.Service.EmailService;

@Service("emailService")
public class DefaultEmailService implements EmailService {
	private static final Logger logger = Logger.getLogger(DefaultEmailService.class);

	@Value("${sms.endpoint}")
	private String url;

	@Value("${sms.hashkey}")
	private String hashKey;

	@Value("${sms.username}")
	private String userName;

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

	@Override
	public void sendSMS(String numbers, String messages) {

		try {
			String user = "username=" + userName;
			String hash = "&hash=" + hashKey;
			String message = "&message=" + messages;
			String number = "&numbers=" + numbers;
			//String test = "&test=" + true;

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			String data = user + hash + number + message ;//+ test;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			logger.info(stringBuffer.toString());

		} catch (Exception e) {
			logger.error("Error SMS " + e);

		}
	}

}
