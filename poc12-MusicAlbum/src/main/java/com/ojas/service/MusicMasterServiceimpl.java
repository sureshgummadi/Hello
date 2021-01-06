package com.ojas.service;

import static com.ojas.constants.Constants.DELETE_TITLE;
import static com.ojas.constants.Constants.GET_ALL_MUSIC_DATA;
import static com.ojas.constants.Constants.GET_BY_MUSIC_ID;
import static com.ojas.constants.Constants.INVALID_FIELDS;
import static com.ojas.constants.Constants.INVALID_REQUEST;
import static com.ojas.constants.Constants.MUSIC_SAVE;
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
import com.ojas.model.MusicMaster;
import com.ojas.model.Title;
import com.ojas.repository.AlbumTypeMasterRepository;
import com.ojas.repository.ArtistRepository;
import com.ojas.repository.GenreMasterRepository;
import com.ojas.repository.MusicMasterRepository;
import com.ojas.repository.TitleRepository;
import com.ojas.response.Response;

@Service
public class MusicMasterServiceimpl implements MusicMasterService {
	@Autowired
	private MusicMasterRepository musicRepository;

	@Autowired
	private AlbumTypeMasterRepository albumTypeRepository;

	@Autowired
	private ArtistRepository artistRepository;

	@Autowired
	private GenreMasterRepository genreRepository;

	@Autowired
	private TitleRepository titleRepository;

	Logger log = Logger.getLogger(this.getClass());

	@Override
	public ResponseEntity<Object> saveMusic(MusicMaster music) {
		log.debug("title request enter into the service class  " + music);
		Response response = null;
		if (music == null) {
			log.error("Invalid request");
			return new ResponseEntity<>(new CustomException(INVALID_REQUEST), HttpStatus.UNPROCESSABLE_ENTITY);
		}

		MusicMaster save = musicRepository.save(music);
		save.setAlbumTypeMaster(albumTypeRepository.findById(music.getAlbumTypeMaster().getAlbumId()).get());
		save.setArtistMaster(artistRepository.findById(music.getArtistMaster().getArtistId()).get());
		save.setGenreMaster(genreRepository.findById(music.getGenreMaster().getGenreId()).get());
		save.setTitleMaster(titleRepository.findById(music.getTitleMaster().getTitleId()).get());
		response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(MUSIC_SAVE);
		response.setTimestamp(new Date());
		response.setData(save);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getById(Long id) {
		log.debug("Incoming request music service id method : " + id);
		if (id == null || id == 0) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<MusicMaster> findById = musicRepository.findById(id);
		if (!findById.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_MUSIC_ID);
		response.setTimestamp(new Date());
		response.setData(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getAllMusics(Integer pageNo, Integer pageSize) {
		log.debug("Incoming request title service getall method ");
		Sort sort = Sort.by("titleId").ascending();
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
		List<MusicMaster> findAllMusics = musicRepository.findAll(pageRequest).toList();
		if (findAllMusics.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_ALL_MUSIC_DATA);
		response.setTimestamp(new Date());
		response.setData(findAllMusics);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteMusic(Long id) {
		log.debug("Incoming request music service delete method : " + id);
		if (id == null || id == 0) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<MusicMaster> findById = musicRepository.findById(id);
		if (!findById.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		Response response = new Response();
		musicRepository.delete(findById.get());
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(DELETE_TITLE);
		response.setTimestamp(new Date());
		response.setData(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
