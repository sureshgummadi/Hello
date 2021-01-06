package com.ojas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TitleMaster")
public class Title {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="title_id")
	private Long titleId;
	@Column(name="title_name")
	private String titleName;
	public Long getTitleId() {
		return titleId;
	}
	public void setTitleId(Long titleId) {
		this.titleId = titleId;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	@Override
	public String toString() {
		return "Title [titleId=" + titleId + ", titleName=" + titleName + "]";
	}
	
	

}
