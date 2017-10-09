package com.examination.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	private static final String FROM="ashish.bhandari4444@gmail.com";
	private static final String PASSWORD="hanumanram";
	
	private static Session getSession(){
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, PASSWORD);
			}
		  });
		return session;
	}
	
	public static void eMailUserCredentials(String userEmail, String password) throws AddressException, MessagingException{
		
		Message message = new MimeMessage(getSession());
		message.setFrom(new InternetAddress("from-email@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(userEmail));
		message.setSubject("Credentials For Examination");
		message.setText("Hello,"
				+ "\n\n You are successfully registered at examination portal"
				+ "\n\n Following is your credentails:"
				+ "\n\n UserName: " + userEmail
				+ "\n Password: " + password
				+ "\n\n **You will recieve another email when your account gets activated");

		Transport.send(message);
	}
}
