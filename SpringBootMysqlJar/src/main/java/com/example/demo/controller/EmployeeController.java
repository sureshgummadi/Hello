package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.response.Response;
import com.example.demo.service.EmployeeService;


@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private MongoTemplate templete;
	
	@Autowired
	private EmployeeRepo repo;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee emp){
		System.out.println("jsdfghsjd");
		try {
			Response response=new Response();
			boolean addOrder = service.addEmployee(emp);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			Response response = new Response();
			response.setStatus("409");
			response.setMessage("Not inser data");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping("/getallord")
	public ResponseEntity<?> getAllOrders1() {
		try {
			List<Employee> list = service.getAll();
			if (list == null) {
				Response response = new Response();
//				log.error("No data found");
				response.setMessage("No Data Found");
				response.setStatus("422");
				return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception exception) {
			Response response = new Response();
//			log.debug("Inside the catch Block : " + exception.getMessage());
			response.setMessage("Ecxeption caught");
			response.setStatus("409");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
}
