package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

	@RequestMapping("show")
	public String showUser() {
		System.out.println("Hello User");
		return null;
	}
}
