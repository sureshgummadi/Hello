package com.example.demo.model;

public class AuthenticatipnResponseJwt {

	private final String jwt;
	public AuthenticatipnResponseJwt(String jwt) {
		this.jwt=jwt;
	}
	public String getJwt() {
		return jwt;
	}
	
}
