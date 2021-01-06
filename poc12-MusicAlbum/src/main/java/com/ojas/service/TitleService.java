package com.ojas.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.model.Title;

@Service
public interface TitleService {
	public ResponseEntity<Object> saveTitle(Title title);

	public ResponseEntity<Object> getById(Long id);

	public ResponseEntity<Object> getAllTitle(Integer pageNo, Integer pageSize);

	public ResponseEntity<Object> deleteTitle(Long id);
}
