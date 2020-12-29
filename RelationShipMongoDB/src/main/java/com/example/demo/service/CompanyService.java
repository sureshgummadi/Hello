package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository repo;
	
		public Boolean addCompany(Company std) {
			Company student = repo.save(std);
			if (student == null) {
				return false;
			}
			return true;
		}
}
