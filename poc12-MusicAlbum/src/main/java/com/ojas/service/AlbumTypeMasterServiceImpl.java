package com.ojas.service;

import static com.ojas.constants.Constants.ALBUM_TYPE_SAVE;
import static com.ojas.constants.Constants.DELETE_ALBUMTYPE;
import static com.ojas.constants.Constants.GET_ALLALBUMTYPE_DATA;
import static com.ojas.constants.Constants.GET_BY_ALBUMTYPE_ID;
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
import com.ojas.model.AlbumTypeMaster;
import com.ojas.repository.AlbumTypeMasterRepository;
import com.ojas.response.Response;

@Service
public class AlbumTypeMasterServiceImpl implements AlbumTypeMasterService {

	@Autowired
	private AlbumTypeMasterRepository albumTypeRepository;

	Logger log = Logger.getLogger(this.getClass());

	@Override
	public ResponseEntity<Object> saveAlbumType(AlbumTypeMaster albumType) {
		log.debug("album type request enter into the service class  " + albumType);
		Response response = null;
		if (albumType == null) {
			log.error("Invalid request");
			return new ResponseEntity<>(new CustomException(INVALID_REQUEST), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if ((albumType.getAlbumName()==null||albumType.getAlbumName().isEmpty()||albumType.getYear()==null)
				) {
			log.error("Fields should not be null");
			throw new CustomException(INVALID_FIELDS);
		}

		AlbumTypeMaster save = albumTypeRepository.save(albumType);
	    response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(ALBUM_TYPE_SAVE);
		response.setTimestamp(new Date());
		response.setData(save);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}	
	

	@Override
		public ResponseEntity<Object> getById(Long id) {
			log.debug("Incoming request Album Type service id method : " + id);
			if (id == null || id == 0) {
				log.error("Invalid request");
				throw new CustomException(INVALID_FIELDS);
			}
			Optional<AlbumTypeMaster> findById = albumTypeRepository.findById(id);
			if (!findById.isPresent()) {
				log.error("Record not found");
				throw new CustomException(RECORD_NOT_FOUND);
			}
			Response response = new Response();
			response.setStatuscode(SUCCESS_STATUS);
			response.setStatus(SUCCESS);
			response.setMessage(GET_BY_ALBUMTYPE_ID);
			response.setTimestamp(new Date());
			response.setData(findById);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	

	@Override
	public ResponseEntity<Object>  getAllAlbumType(Integer pageNo, Integer pageSize) {
		
		
			log.debug("Incoming request artist service getall method ");
			Sort sort = Sort.by("albumId").ascending();
			PageRequest pageRequest = PageRequest.of(pageNo, pageSize,sort);
			List<AlbumTypeMaster> findAllAlbumTypes = albumTypeRepository.findAll(pageRequest).toList();
			if (findAllAlbumTypes.isEmpty()) {
				log.error("Record not found");
				throw new CustomException(RECORD_NOT_FOUND);
			}
			Response response = new Response();
			response.setStatuscode(SUCCESS_STATUS);
			response.setStatus(SUCCESS);
			response.setMessage(GET_ALLALBUMTYPE_DATA);
			response.setTimestamp(new Date());
			response.setData(findAllAlbumTypes);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
	

	@Override
	public ResponseEntity<Object> deleteAlbumType(Long id) {
		
		log.debug("Incoming request Album Type service delete method : " + id);
		if (id == null || id == 0) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<AlbumTypeMaster> findById = albumTypeRepository.findById(id);
		if (!findById.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		albumTypeRepository.delete(findById.get());
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(DELETE_ALBUMTYPE);
		response.setTimestamp(new Date());
		response.setData(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
		
}

