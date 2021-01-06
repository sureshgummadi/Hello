package com.ojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.model.GenreMaster;

@Repository
public interface GenreMasterRepository extends JpaRepository<GenreMaster, Long> {

}
