package com.ojas.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.model.AlbumTypeMaster;

@Service
public interface AlbumTypeMasterService {
	
	public ResponseEntity<Object> saveAlbumType(AlbumTypeMaster albumType);

	public ResponseEntity<Object> getById(Long id);

	public ResponseEntity<Object> getAllAlbumType(Integer pageNo, Integer pageSize);

	public ResponseEntity<Object> deleteAlbumType(Long id);
}
