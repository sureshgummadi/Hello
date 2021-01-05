package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.response.Response;
import com.example.demo.service.StudentService;
import com.example.demo.statuscodes.GlobelMessages;
import com.example.demo.validate.Validations;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping("/save")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {

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
			boolean addStudent = service.addStudent(student);
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
			response.setMessage(GlobelMessages.error + " : " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
	@GetMapping("/students")
	public ResponseEntity<?> getAllStudents(){
		try {
			
			List<Student> list=service.getStudents();
			if (list==null) {
				Response response = new Response();
				response.setMessage(GlobelMessages.Invalid_Data);
				response.setStatus("422");
				return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			Response response = new Response();
			response.setMessage(GlobelMessages.Exception);
			response.setStatus("409");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}	
	}
	
	
	@GetMapping("/getByid/{id}")
	public ResponseEntity<?> getByid(@PathVariable("id") String id) {
		try {
			if (id == null) {
				Response response = new Response();
				response.setMessage(GlobelMessages.error);
				response.setStatus("422");
				return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			Student std = service.getByStudentId(id);
			if (std == null) {
				throw new ResourceNotFoundException("No Data Found This Id");
			}
			return new ResponseEntity<>(std, HttpStatus.OK);
		} catch (ResourceNotFoundException exception) {
			Response response = new Response();
			response.setMessage(GlobelMessages.Invalid_Data);
			response.setStatus("409");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		} catch (Exception exception) {
			Response response = new Response();
			response.setMessage(GlobelMessages.Invalid_Data);
			response.setStatus("409");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
}
