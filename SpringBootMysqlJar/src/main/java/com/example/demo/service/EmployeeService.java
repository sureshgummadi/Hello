package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private MongoTemplate templete;
	
	public Boolean addEmployee(Employee std) {
		Employee student = repo.save(std);
		if (student == null) {
			return false;
		}
		return true;
	}
	
	public List<Employee> getAll(){
		System.out.println("sdhgf");
		List<Employee> emp=templete.findAll(Employee.class);
		return emp;	
	}
	
}
