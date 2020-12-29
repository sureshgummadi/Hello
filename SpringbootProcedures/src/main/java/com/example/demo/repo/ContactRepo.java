package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Contact;

public interface ContactRepo extends JpaRepository<Contact, Long>{
	
	Contact findByName(String name);
	Optional<Contact> findById(Long id);
	List<Contact> findByNameLike(String nameWhere);

}
