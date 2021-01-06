package com.ojas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artistmaster")
public class Artist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "artist_id")
	private Long artistId;
	@Column(name = "artist_name")
	private String artistName;
	@Column(name = "profession")
	private String profession;
	public Long getArtistId() {
		return artistId;
	}
	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + ", profession=" + profession + "]";
	}
	
	
}
