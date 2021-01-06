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

import com.ojas.model.Artist;
import com.ojas.service.ArtistService;

@RequestMapping("/musicalbum/artist")
@RestController
public class ArtistController {
Logger log = Logger.getLogger(this.getClass());

	
	@Autowired
	private ArtistService artistService;
 
	@PostMapping("/save")
	public ResponseEntity<Object>saveArtist(@RequestBody Artist artist){
		log.debug("req enter into the controller"+artist);
	ResponseEntity<Object> saveArtist = artistService.saveArtist(artist);
		return new ResponseEntity<Object>(saveArtist, HttpStatus.OK);
		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
			ResponseEntity<Object> getById = artistService.getById(id);
			return new ResponseEntity<Object>(getById, HttpStatus.OK);
		
	}

	@GetMapping(value = {"/getAll/{pageNo}/{pageSize}"})
	public ResponseEntity<Object> getAll(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
		if (pageNo == null || pageSize == null) {
			return new ResponseEntity<Object>("no records", HttpStatus.CONFLICT);
		}
		ResponseEntity<Object> getAllArtists = artistService.getAllArtists(pageNo, pageSize);
		return new ResponseEntity<Object>(getAllArtists, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
			ResponseEntity<Object> deleteArtist = artistService.deleteArtist(id);
			return new ResponseEntity<Object>(deleteArtist, HttpStatus.OK);
		}
}






