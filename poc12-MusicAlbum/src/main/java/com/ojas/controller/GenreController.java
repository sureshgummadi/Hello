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

import com.ojas.model.GenreMaster;
import com.ojas.model.Title;
import com.ojas.service.GenreMasterService;
import com.ojas.service.TitleService;

@RestController
@RequestMapping("/musicalbum/genre")
public class GenreController {
	@Autowired
	private GenreMasterService genreService;
	Logger log = Logger.getLogger(this.getClass());
	@PostMapping("/save")
	public ResponseEntity<Object>saveGenre(@RequestBody GenreMaster genreMaster){
		log.debug("req enter into the controller"+genreMaster);
	ResponseEntity<Object> saveGenre = genreService.saveGenreMaster(genreMaster);
		return new ResponseEntity<Object>(saveGenre, HttpStatus.OK);
		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
			ResponseEntity<Object> getById = genreService.getById(id);
			return new ResponseEntity<Object>(getById, HttpStatus.OK);
		
	}

	@GetMapping(value = {"/getAll/{pageNo}/{pageSize}"})
	public ResponseEntity<Object> getAll(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
		if (pageNo == null || pageSize == null) {
			return new ResponseEntity<Object>("no records", HttpStatus.CONFLICT);
		}
		ResponseEntity<Object> getAllGenre = genreService.getAllGenreMasters(pageNo, pageSize);
		return new ResponseEntity<Object>(getAllGenre, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
			ResponseEntity<Object> deleteGenre = genreService.deleteGenreMaster(id);
			return new ResponseEntity<Object>(deleteGenre, HttpStatus.OK);
		}
}




