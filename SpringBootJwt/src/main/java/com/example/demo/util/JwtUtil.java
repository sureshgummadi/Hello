package com.example.demo.util;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	private String SECURT_KEY="secret";
	
	public String extractUsername(String token) {
		return extractCliam(token,Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return (Date) extractCliam(token,Claims::getExpiration);
	}
	
	public <T> T extractCliam(String token,Function<Claims,T> climasReslover) {
		final Claims claims=extractAllClimes(token);
		return climasReslover.apply(claims);
	}
	
	public Claims extractAllClimes(String token) {
		return Jwts.parser().setSigningKey(SECURT_KEY).parseClaimsJws(token).getBody();
	}
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date(0));
	}
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims=new HashMap<>();
		return createToken(claims,userDetails.getUsername());
	}
	private String createToken(Map<String,Object> claims,String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
				.signWith(SignatureAlgorithm.HS384, SECURT_KEY).compact();
		
		//Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	public Boolean validateToken(String token,UserDetails userDetails) {
		final String username=extractUsername(token);
		return  (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
