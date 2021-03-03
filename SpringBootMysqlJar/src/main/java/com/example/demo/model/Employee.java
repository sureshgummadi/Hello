package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document("emp")
@Data
public class Employee {

	private String _id;
	private String name;
	private float salary;
}
