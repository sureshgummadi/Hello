package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AuthenticationRequestModel;
import com.example.demo.model.AuthenticatipnResponseJwt;
import com.example.demo.services.MyUserDetails;
import com.example.demo.util.JwtUtil;

@RestController
public class UserController {
	@Autowired
	private AuthenticationManager auManager;
	@Autowired
	private MyUserDetails userDetails;
	@Autowired
	private JwtUtil jwtutil;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "Hello World";
	}
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestModel armodel)throws Exception{
		try {
		auManager.authenticate(new UsernamePasswordAuthenticationToken(armodel.getUsername(),armodel.getPassword()));
		}catch(BadCredentialsException ex) {
			throw new Exception("Incerect Username and Password",ex);
		}
		final UserDetails userDetails1=userDetails.loadUserByUsername(armodel.getUsername());
		final String jwt=jwtutil.generateToken(userDetails1);
		return ResponseEntity.ok(new AuthenticatipnResponseJwt(jwt));
		}
}
