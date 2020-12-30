package org.mail.SpringMail.mailsender;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class AppMailSender {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendMail(String to, String sub, String text,FileSystemResource file) {
		boolean status =false;
		try {
			System.out.println("hai");
			MimeMessage message=javaMailSender.createMimeMessage();
			System.out.println("hello"+message);
			System.out.println(file);
			MimeMessageHelper helper=new MimeMessageHelper(message,file!=null?true:false);
			System.out.println(helper);
			helper.setTo(to);
			helper.setFrom("ganeshkona777@gmail.com");
			helper.setSubject(sub);
			helper.setText(text);
			helper.addAttachment(file.getFilename(),file);
			System.out.println(javaMailSender+"hello");
			javaMailSender.send(message);
			
			status=true;
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
			System.out.println(e);
		}
		return status;		
	}
}
