package com.ojas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genremaster")
public class GenreMaster {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "genre_id")
	private Long genreId;

	@Column(name = "genre_name")
	private String genreName;

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "GenreMaster [genreId=" + genreId + ", genreName=" + genreName + "]";
	}
	
	
}
