package org.mail.SpringMail;

import org.mail.SpringMail.config.AppConfig;
import org.mail.SpringMail.mailsender.AppMailSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class App {
	public static void main( String[] args )
    {
		ApplicationContext act = new AnnotationConfigApplicationContext(AppConfig.class);
		AppMailSender mail = act.getBean("appMailSender",AppMailSender.class);
		FileSystemResource file = new FileSystemResource("C:/Users/vg19434/Desktop/MyProfile/VenkataSubbaiahGummadi.jpg");
		boolean flag = mail.sendMail("ganeshkona777@gmail.com", "Hello", "Welcome To Spring Email", file);
		//System.out.println(flag);
	    if(flag) {
	    System.out.println("Done!!!");
	    }else {
	    System.out.println("Sorry!!!!");
	    }
    }
}
