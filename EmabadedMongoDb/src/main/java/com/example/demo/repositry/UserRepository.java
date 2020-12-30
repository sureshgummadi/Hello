package com.example.demo.repositry;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {

	public List<User> findByname(String name);
	//@Query("{'Address.city':?0}") 
	public List<User> findByAddrCity(String city);
	 
}
