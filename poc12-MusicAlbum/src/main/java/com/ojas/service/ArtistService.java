package com.ojas.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.model.Artist;

@Service
public interface ArtistService {

	public ResponseEntity<Object> getById(Long id);

	public ResponseEntity<Object> getAllArtists(Integer pageNo, Integer pageSize);

	public ResponseEntity<Object> deleteArtist(Long id);

	public ResponseEntity<Object> saveArtist(Artist artist);
}
