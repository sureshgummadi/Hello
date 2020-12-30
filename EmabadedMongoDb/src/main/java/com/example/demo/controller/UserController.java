package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repositry.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository repo;
	
	@PostMapping("/save")
	public String paleUser(@RequestBody User user) {
		repo.save(user);
		return "Successfully";
	}
	
	  @GetMapping("/firstName/{name}") 
	  public List<User> getByName(@PathVariable("name") String name)
	  { 
		  return repo.findByname(name); 
	  }
	  
	
	  @GetMapping("/findCity/{city}") 
	  public List<User> getByCity(@PathVariable("city") String city) 
	  { 
		  return repo.findByAddrCity(city); 
		  
	  }
	 
	 
}
