package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BanerMoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(BanerMoApplication.class, args);
		SpringApplication sa = new SpringApplication (BanerMoApplication.class);
		
		sa.setBannerMode(Banner.Mode.LOG);
		ConfigurableApplicationContext c = sa.run(args);
		 System.out.println(c.getClass().getName().toString());
	}
}
