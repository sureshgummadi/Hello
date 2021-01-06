package com.ojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long>{

}
