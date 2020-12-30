package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Student {	
	private String id;
	private String name;
	private String class1;
	private String address;
	private String emailId;
	private String phone;
}
