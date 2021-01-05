package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table
public class AuthenticationRequestModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String username;
	private String password;
	
	@Autowired
	private List<Roles> role;
	
	
	public AuthenticationRequestModel() {
		super();
	}
	public AuthenticationRequestModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public final List<Roles> getRole() {
		return role;
	}
	public final void setRole(List<Roles> role) {
		this.role = role;
	}
	
}
