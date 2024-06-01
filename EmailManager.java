package HelperClasses;

import java.io.File;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailManager {
    public static void sentEmail(String from,String to,String subject,String body,boolean attachment,String attachmentPath){
        Properties properties=System.getProperties();
    	properties.put("mail.smtp.host", "smtp.gmail.com");    
    	properties.put("mail.smtp.socketFactory.port", "465");    
    	properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");    
    	properties.put("mail.smtp.auth", "true");    
    	properties.put("mail.smtp.port", "465");   
    	
        System.out.println("TO : "+to+" From : "+from+" Subject : "+subject);
        
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {    
     		protected PasswordAuthentication getPasswordAuthentication() {    
     			return new PasswordAuthentication(from, "ewfhvyelyyjuoydj");  
     		}    
    	});
		       
        session.setDebug(true);
        
    	try {    
     		MimeMessage message = new MimeMessage(session);    
     		message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
     		message.setSubject(subject);    
     		message.setText(body);    
			Transport.send(message);    
     		System.out.println("message sent successfully");    
    	} 
    	catch (MessagingException e) {
    		System.out.println(e);
    	}    	
	}
}    
