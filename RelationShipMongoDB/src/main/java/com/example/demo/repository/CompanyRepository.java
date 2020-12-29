package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Company;
public interface CompanyRepository extends MongoRepository<Company, String> {
	
}
