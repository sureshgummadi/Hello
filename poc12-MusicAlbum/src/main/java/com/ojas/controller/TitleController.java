package com.ojas.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.Title;
import com.ojas.service.TitleService;

@RequestMapping("/musicalbum/title")
@RestController
public class TitleController {
Logger log = Logger.getLogger(this.getClass());

	
	@Autowired
	private TitleService titleService;
 
	@PostMapping("/save")
	public ResponseEntity<Object>saveTitle(@RequestBody Title title){
		log.debug("req enter into the controller"+title);
	ResponseEntity<Object> saveTitle = titleService.saveTitle(title);
		return new ResponseEntity<Object>(saveTitle, HttpStatus.OK);
		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
			ResponseEntity<Object> getById = titleService.getById(id);
			return new ResponseEntity<Object>(getById, HttpStatus.OK);
		
	}

	@GetMapping(value = {"/getAll/{pageNo}/{pageSize}"})
	public ResponseEntity<Object> getAll(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
		if (pageNo == null || pageSize == null) {
			return new ResponseEntity<Object>("no records", HttpStatus.CONFLICT);
		}
		ResponseEntity<Object> getAllTitles = titleService.getAllTitle(pageNo, pageSize);
		return new ResponseEntity<Object>(getAllTitles, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
			ResponseEntity<Object> deleteTitle = titleService.deleteTitle(id);
			return new ResponseEntity<Object>(deleteTitle, HttpStatus.OK);
		}
}




