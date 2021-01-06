package com.ojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.model.AlbumTypeMaster;

@Repository
public interface AlbumTypeMasterRepository extends JpaRepository<AlbumTypeMaster, Long>{


	//Optional<AlbumTypeMaster> findById(Long id);

	//Optional<AlbumTypeMaster> findById(Integer id);

}
