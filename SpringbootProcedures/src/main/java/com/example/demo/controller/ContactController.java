package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contact;
import com.example.demo.repo.ContactRepo;
import com.example.demo.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	ContactRepo repo;
	@Autowired
	ContactService service;

	// jpa save
	@PostMapping("/save")
	public Contact saveContact(@RequestBody Contact contact) {
		System.out.println(contact.getName() + " " + contact.getPhone() + " " + contact.getMail());
		return this.repo.save(contact);
	}

	// jpa findByName
	@GetMapping("/get/{mail}")
	public List<Contact> indContactLikeName(String mail) {
		String nameWhere = StringUtils.join(new String[] { "%", mail, "%" }, "");
		List<Contact> contacts = this.repo.findByNameLike(nameWhere);
		return contacts;
	}

	// Query FindByName
	@GetMapping("/query/{name}")
	public List<Contact> findContactsUseDyanamicQueryLikeName(String name) {
		String nameWhere = StringUtils.join(new String[] { "%", name, "%" }, "");
		List<Contact> contacts = service.findAllByViaQuery(nameWhere);
		if (contacts == null) {
			return new ArrayList<Contact>();
		} else {
			return contacts;
		}
	}

	// procedure save data
	@PostMapping("/poc/save")
	public boolean saveContactProc(@RequestBody Contact con) {
		Contact addContactDetails = service.addContactDetails1(con);
		if (addContactDetails != null) {
			return true;
		} else {
			return false;
		}
	}

	// procedure FindByName
	@GetMapping(path = "/get/pro/{name}")
	public List<Contact> findContactsUseProcLikeName(@PathVariable("name") String name) {
		String nameWhere = StringUtils.join(new String[] { "%", name, "%" }, "");
		List<Contact> contacts = service.findAllViaProc(nameWhere);
		if (contacts == null) {
			return new ArrayList<Contact>();
		} else {
			return contacts;
		}
	}

	// procedure findById
	@GetMapping(path = "/find/{id}")
	public List<Contact> findContactsUseProcId(@PathVariable(value = "id") Long id) {
		return service.findAllViaProcId(id);
	}
	//procedure getall
	@GetMapping(path = "/findall")
	public List<Contact> findAllContactByProc(){
		return service.getAllContactProc();
		
	}
}
