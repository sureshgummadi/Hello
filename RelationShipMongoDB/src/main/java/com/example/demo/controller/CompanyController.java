package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Company;
import com.example.demo.response.Response;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("/companyCon")
public class CompanyController {
	/*
	 * @Autowired private CompanyRepository repo;
	 */
	@Autowired
	private CompanyService serv;
	//sysooooo
	//helloooo
	@PostMapping("/save")
	public ResponseEntity<?> saveEmployee(@RequestBody Company com) {

		try {
			Response response = new Response();
//
//			if (student == null) {
//				response.setStatus("400");
//				response.setMessage(GlobelMessages.error);
//				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//			}
//		
//			if (student.getName() == null || student.getName().isEmpty() || student.getClass1() == null
//					|| student.getClass1().isEmpty() || student.getEmailId() == null || student.getEmailId().isEmpty()
//					|| student.getAddress() == null || student.getAddress().isEmpty() || student.getPhone() == null
//					|| student.getPhone().isEmpty()) {
//				response.setStatus("400");
//				response.setMessage(GlobelMessages.error);
//				System.out.println(response+"heeee");
//				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//			}
//			if (!Validations.isEmailValid(student.getEmailId())) {
//				response.setStatus("400");
//				response.setMessage(GlobelMessages.Invalid_Data);
//				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//
//			}
//			if (!Validations.isMobileValid(student.getPhone())) {
//				response.setStatus("400");
//				response.setMessage(GlobelMessages.Invalid_Data);
//				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//			}
			boolean addStudent = serv.addCompany(com);
			/*if (addStudent) {
				response.setStatus("200");
				response.setMessage(GlobelMessages.success);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.setStatus("417");
				response.setMessage(GlobelMessages.error);*/
				return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		} catch (Exception e) {
			Response response = new Response();
			response.setStatus("409");
			response.setMessage("Not inser data");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
	
}
