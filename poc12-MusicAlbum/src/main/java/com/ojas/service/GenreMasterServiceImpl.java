package com.ojas.service;

import static com.ojas.constants.Constants.DELETE_TITLE;
import static com.ojas.constants.Constants.GENRE_MASTER_SAVE;
import static com.ojas.constants.Constants.GET_ALL_GENRE_MASTER_DATA;
import static com.ojas.constants.Constants.GET_BY_GENRE_MASTER_ID;
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
import com.ojas.model.GenreMaster;
import com.ojas.model.Title;
import com.ojas.repository.GenreMasterRepository;
import com.ojas.response.Response;

@Service
public class GenreMasterServiceImpl implements GenreMasterService{
	@Autowired
	private GenreMasterRepository genreMasterRepository;

	Logger log = Logger.getLogger(this.getClass());

	@Override
	public ResponseEntity<Object> saveGenreMaster(GenreMaster genreMaster) {
		log.debug("title request enter into the service class  " + genreMaster);
		Response response = null;
		if (genreMaster == null) {
			log.error("Invalid request");
			return new ResponseEntity<>(new CustomException(INVALID_REQUEST), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if ((genreMaster.getGenreName()==null||genreMaster.getGenreName().isEmpty())) {
			log.error("Fields should not be null");
			throw new CustomException(INVALID_FIELDS);
		}

		GenreMaster save = genreMasterRepository.save(genreMaster);
	    response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GENRE_MASTER_SAVE);
		response.setTimestamp(new Date());
		response.setData(save);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getById(Long id) {
		log.debug("Incoming request title service id method : " + id);
		if (id == null || id == 0) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<GenreMaster> findById = genreMasterRepository.findById(id);
		if (!findById.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_GENRE_MASTER_ID);
		response.setTimestamp(new Date());
		response.setData(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getAllGenreMasters(Integer pageNo, Integer pageSize) {
		log.debug("Incoming request genre service getall method ");
		Sort sort = Sort.by("genreId").ascending();
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize,sort);
		List<GenreMaster> findAllGenre = genreMasterRepository.findAll(pageRequest).toList();
		if (findAllGenre.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_ALL_GENRE_MASTER_DATA);
		response.setTimestamp(new Date());
		response.setData(findAllGenre);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteGenreMaster(Long id) {
		log.debug("Incoming request genre service delete method : " + id);
		if (id == null || id == 0) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<GenreMaster> findById = genreMasterRepository.findById(id);
		if (!findById.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		genreMasterRepository.delete(findById.get());
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(DELETE_TITLE);
		response.setTimestamp(new Date());
		response.setData(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
