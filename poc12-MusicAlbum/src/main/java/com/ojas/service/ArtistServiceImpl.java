package com.ojas.service;

import static com.ojas.constants.Constants.ARTIST_SAVE;
import static com.ojas.constants.Constants.DELETE_ARTIST;
import static com.ojas.constants.Constants.GET_ALL_ARTIST_DATA;
import static com.ojas.constants.Constants.GET_BY_ARTIST_ID;
import static com.ojas.constants.Constants.INVALID_FIELDS;
import static com.ojas.constants.Constants.INVALID_REQUEST;
import static com.ojas.constants.Constants.RECORD_NOT_FOUND;
import static com.ojas.constants.Constants.SUCCESS;
import static com.ojas.constants.Constants.SUCCESS_STATUS;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.exception.CustomException;
import com.ojas.model.Artist;
import com.ojas.repository.ArtistRepository;
import com.ojas.response.Response;

@Service
public class ArtistServiceImpl implements ArtistService {
	
	@Autowired
	private ArtistRepository artistRepository;

	Logger log = Logger.getLogger(this.getClass());


	@Override
	public ResponseEntity<Object> saveArtist(Artist artist) {
		log.debug("title request enter into the service class  " + artist);
		Response response = null;
		if (artist == null) {
			log.error("Invalid request");
			return new ResponseEntity<>(new CustomException(INVALID_REQUEST), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if ((artist.getArtistName()==null||artist.getArtistName().isEmpty()||artist.getProfession()==null||artist.getProfession().isEmpty())) {
			log.error("Fields should not be null");
			throw new CustomException(INVALID_FIELDS);
		}
		Artist save = artistRepository.save(artist);
	    response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(ARTIST_SAVE);
		response.setTimestamp(new Date());
		response.setData(save);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getById(Long id) {
		log.debug("Incoming request Artist service id method : " + id);
		if (id == null || id == 0) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<Artist> findById = artistRepository.findById(id);
		if (!findById.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_ARTIST_ID);
		response.setTimestamp(new Date());
		response.setData(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Object> getAllArtists(Integer pageNo, Integer pageSize) {
		log.debug("Incoming request artist service getall method ");
		Sort sort = Sort.by("artistId").ascending();
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize,sort);
		List<Artist> findAllArtists = artistRepository.findAll(pageRequest).toList();
		if (findAllArtists.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_ALL_ARTIST_DATA);
		response.setTimestamp(new Date());
		response.setData(findAllArtists);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteArtist(Long id) {
		log.debug("Incoming request Artist service delete method : " + id);
		if (id == null || id == 0) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<Artist> findById = artistRepository.findById(id);
		if (!findById.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		artistRepository.delete(findById.get());
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(DELETE_ARTIST);
		response.setTimestamp(new Date());
		response.setData(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
