package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/")
public class SpringsecondJarFileApplication {
	@GetMapping("/hello")
	public String home() {
		return "welcome to docker";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringsecondJarFileApplication.class, args);
	}

}
