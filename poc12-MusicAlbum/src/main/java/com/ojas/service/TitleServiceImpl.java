package com.ojas.service;

import static com.ojas.constants.Constants.DELETE_TITLE;
import static com.ojas.constants.Constants.GET_ALL_TITLE_DATA;
import static com.ojas.constants.Constants.GET_BY_TITLE_ID;
import static com.ojas.constants.Constants.INVALID_FIELDS;
import static com.ojas.constants.Constants.INVALID_REQUEST;
import static com.ojas.constants.Constants.RECORD_NOT_FOUND;
import static com.ojas.constants.Constants.SUCCESS;
import static com.ojas.constants.Constants.SUCCESS_STATUS;
import static com.ojas.constants.Constants.TITLE_SAVE;

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
import com.ojas.model.Title;
import com.ojas.repository.TitleRepository;
import com.ojas.response.Response;

@Service
public class TitleServiceImpl implements TitleService {
	@Autowired
	private TitleRepository titleRepository;

	Logger log = Logger.getLogger(this.getClass());


	@Override
	public ResponseEntity<Object> saveTitle(Title title) {
		log.debug("title request enter into the service class  " + title);
		Response response = null;
		if (title == null) {
			log.error("Invalid request");
			return new ResponseEntity<>(new CustomException(INVALID_REQUEST), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if ((title.getTitleName()==null||title.getTitleName().isEmpty())) {
			log.error("Fields should not be null");
			throw new CustomException(INVALID_FIELDS);
		}

		Title save = titleRepository.save(title);
	    response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(TITLE_SAVE);
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
		Optional<Title> findById = titleRepository.findById(id);
		if (!findById.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_TITLE_ID);
		response.setTimestamp(new Date());
		response.setData(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getAllTitle(Integer pageNo, Integer pageSize) {
		log.debug("Incoming request title service getall method ");
		Sort sort = Sort.by("titleId").ascending();
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize,sort);
		List<Title> findAllJobs = titleRepository.findAll(pageRequest).toList();
		if (findAllJobs.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_ALL_TITLE_DATA);
		response.setTimestamp(new Date());
		response.setData(findAllJobs);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteTitle(Long id) {
		log.debug("Incoming request title service delete method : " + id);
		if (id == null || id == 0) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<Title> findById = titleRepository.findById(id);
		if (!findById.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		titleRepository.delete(findById.get());
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(DELETE_TITLE);
		response.setTimestamp(new Date());
		response.setData(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
		

}
