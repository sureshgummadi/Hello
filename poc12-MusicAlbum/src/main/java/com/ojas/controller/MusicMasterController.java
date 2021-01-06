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

import com.ojas.model.MusicMaster;
import com.ojas.model.Title;
import com.ojas.service.MusicMasterService;
import com.ojas.service.MusicMasterServiceimpl;
import com.ojas.service.TitleService;

@RestController
@RequestMapping("/musicalbum/music")
public class MusicMasterController {
Logger log = Logger.getLogger(this.getClass());

	
	@Autowired
	private MusicMasterServiceimpl musicService;
 
	@PostMapping("/save")
	public ResponseEntity<Object>saveMusic(@RequestBody MusicMaster music){
		log.debug("req enter into the controller"+music);
	ResponseEntity<Object> saveMusic= musicService.saveMusic(music);
		return new ResponseEntity<Object>(saveMusic, HttpStatus.OK);
		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
			ResponseEntity<Object> getById = musicService.getById(id);
			return new ResponseEntity<Object>(getById, HttpStatus.OK);
		
	}

	@GetMapping(value = {"/getAll/{pageNo}/{pageSize}"})
	public ResponseEntity<Object> getAll(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
		if (pageNo == null || pageSize == null) {
			return new ResponseEntity<Object>("no records", HttpStatus.CONFLICT);
		}
		ResponseEntity<Object> getAllMusics = musicService.getAllMusics(pageNo, pageSize);
		return new ResponseEntity<Object>(getAllMusics, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
			ResponseEntity<Object> deleteMusic = musicService.deleteMusic(id);
			return new ResponseEntity<Object>(deleteMusic, HttpStatus.OK);
		}
}




