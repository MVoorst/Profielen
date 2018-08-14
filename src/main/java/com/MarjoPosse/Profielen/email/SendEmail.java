package com.MarjoPosse.Profielen.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class SendEmail {
	
	@Value("${mail.host}")
	private String host;
	
	private String from;
	private String username;
	private String password;
	
	public void sendEmail(String to, String subject, String emailbody) throws MessagingException{
	      // Recipient's email ID needs to be mentioned.
		 
	      // Sender's email ID needs to be mentioned
	      String from = "p.vanhout83@gmail.com";
	      final String username = "p.vanhout83";//change accordingly
	      final String password = "MercedesB250";//change accordingly

	      // Assuming you are sending email through smtp.gmail.com
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "25");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });

	      try {
		   // Create a default MimeMessage object.
		   Message message = new MimeMessage(session);
		
		   // Set From: header field of the header.
		   message.setFrom(new InternetAddress(from));
		
		   // Set To: header field of the header.
		   message.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(to));
		
		   // Set Subject: header field
		   message.setSubject(subject);
		
		   // Now set the actual message
		   message.setText(emailbody);

		   // Send message
			   Transport.send(message);
			   
			   System.out.println("Sent message successfully....");
		   
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	   }
	}
