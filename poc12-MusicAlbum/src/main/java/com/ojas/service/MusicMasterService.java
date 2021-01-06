package com.ojas.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.model.MusicMaster;

@Service
public interface MusicMasterService {
	
	public ResponseEntity<Object> saveMusic(MusicMaster music);

	public ResponseEntity<Object> getById(Long id);

	public ResponseEntity<Object> getAllMusics(Integer pageNo, Integer pageSize);

	public ResponseEntity<Object> deleteMusic(Long id);

	

}
