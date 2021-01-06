package com.ojas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="music_master")
public class MusicMaster {
	
	@ManyToOne
	private AlbumTypeMaster albumTypeMaster;
	@ManyToOne
	private Artist artistMaster;
	@ManyToOne
	private GenreMaster genreMaster;
	@ManyToOne
	private Title titleMaster;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long musicId;

	public AlbumTypeMaster getAlbumTypeMaster() {
		return albumTypeMaster;
	}

	public void setAlbumTypeMaster(AlbumTypeMaster albumTypeMaster) {
		this.albumTypeMaster = albumTypeMaster;
	}

	public Artist getArtistMaster() {
		return artistMaster;
	}

	public void setArtistMaster(Artist artistMaster) {
		this.artistMaster = artistMaster;
	}

	public GenreMaster getGenreMaster() {
		return genreMaster;
	}

	public void setGenreMaster(GenreMaster genreMaster) {
		this.genreMaster = genreMaster;
	}

	public Title getTitleMaster() {
		return titleMaster;
	}

	public void setTitleMaster(Title titleMaster) {
		this.titleMaster = titleMaster;
	}

	public Long getMusicId() {
		return musicId;
	}

	public void setMusicId(Long musicId) {
		this.musicId = musicId;
	}

	@Override
	public String toString() {
		return "MusicMaster [albumTypeMaster=" + albumTypeMaster + ", artistMaster=" + artistMaster + ", genreMaster="
				+ genreMaster + ", titleMaster=" + titleMaster + ", musicId=" + musicId + ", getAlbumTypeMaster()="
				+ getAlbumTypeMaster() + ", getArtistMaster()=" + getArtistMaster() + ", getGenreMaster()="
				+ getGenreMaster() + ", getTitleMaster()=" + getTitleMaster() + ", getMusicId()=" + getMusicId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
