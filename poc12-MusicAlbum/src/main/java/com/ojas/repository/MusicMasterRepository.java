package com.ojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.model.MusicMaster;

@Repository
public interface MusicMasterRepository extends JpaRepository<MusicMaster, Long>{

}
