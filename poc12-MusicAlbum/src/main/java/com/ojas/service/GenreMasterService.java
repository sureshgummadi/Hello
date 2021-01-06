package com.ojas.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.model.GenreMaster;
@Service
public interface GenreMasterService {

	public ResponseEntity<Object> saveGenreMaster(GenreMaster genreMaster);

	public ResponseEntity<Object> getById(Long id);

	public ResponseEntity<Object> getAllGenreMasters(Integer pageNo, Integer pageSize);

	public ResponseEntity<Object> deleteGenreMaster(Long id);
}
