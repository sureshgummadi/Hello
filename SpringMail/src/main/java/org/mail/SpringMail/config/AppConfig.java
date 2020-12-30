package org.mail.SpringMail.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages="org.mail")
public class AppConfig {

	@Bean
	public JavaMailSenderImpl mailImpl() {
		JavaMailSenderImpl impl=new JavaMailSenderImpl();
		impl.setHost("smtp.gmail.com");
		impl.setPort(587);
		impl.setUsername("subbugummadi10@gmail.com");
		impl.setPassword("subbu1008");
		impl.setJavaMailProperties(props());
		return impl;
		
	}

	private Properties props() {
		Properties p=new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		//p.put("mail.smtp.port", "25");
		return p;
	}
	
}
