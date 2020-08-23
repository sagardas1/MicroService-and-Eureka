package com.shopingCart;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage; 
public class MailSend {
public static void main(String[] args) throws AddressException, MessagingException {
	java.util.Properties props = new java.util.Properties();
	props.put("mail.smtp.host", "smtp.myisp.com");
	Session session = Session.getDefaultInstance(props, null);

	// Construct the message
	String to = "sagardas.195@gmail.com";
	String from = "sagardas.195@gmail.com";
	String subject = "Hello";
	Message msg = new MimeMessage(session);
	
	    msg.setFrom(new InternetAddress(from));
	    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    msg.setSubject(subject);
	    msg.setText("Hi,\n\nHow are you?");

	    // Send the message.
	    Transport.send(msg);
	    System.out.println("dfg");
   }
}
