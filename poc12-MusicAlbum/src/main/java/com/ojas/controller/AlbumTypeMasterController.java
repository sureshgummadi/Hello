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

import com.ojas.model.AlbumTypeMaster;
import com.ojas.service.AlbumTypeMasterServiceImpl;
@RequestMapping("/musicalbum/albumtype")
@RestController
public class AlbumTypeMasterController {
	
	Logger log = Logger.getLogger(this.getClass());

	
	@Autowired
	private AlbumTypeMasterServiceImpl albumTypeService;
 
	@PostMapping("/save")
	public ResponseEntity<Object>saveAlbumTypeMaster(@RequestBody AlbumTypeMaster albumType){
		log.debug("req enter into the controller"+albumType);
	ResponseEntity<Object> saveAlbumType = albumTypeService.saveAlbumType(albumType);
		return new ResponseEntity<Object>(saveAlbumType, HttpStatus.OK);
		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
			ResponseEntity<Object> getById = albumTypeService.getById(id);
			return new ResponseEntity<Object>(getById, HttpStatus.OK);
		
	}

	@GetMapping(value = {"/getAll/{pageNo}/{pageSize}"})
	public ResponseEntity<Object> getAll(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
		if (pageNo == null || pageSize == null) {
			return new ResponseEntity<Object>("no records", HttpStatus.CONFLICT);
		}
		ResponseEntity<Object> getAllEmployee = albumTypeService.getAllAlbumType(pageNo, pageSize);
		return new ResponseEntity<Object>(getAllEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
			ResponseEntity<Object> deleteEmployee = albumTypeService.deleteAlbumType(id);
			return new ResponseEntity<Object>(deleteEmployee, HttpStatus.OK);
		}
}


