package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Chain;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.services.MyUserDetails;
import com.example.demo.util.JwtUtil;
@Component

public class JwtRequestFilter extends OncePerRequestFilter{
	@Autowired
	//@Qualifier("userDetailsService")
	private MyUserDetails userdetails;
	@Autowired
	private JwtUtil jwtutil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHeader=request.getHeader("Authorization");
		String username=null;
		String jwt=null;

		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
			jwt=authorizationHeader.substring(7);
			username=jwtutil.extractUsername(jwt);
		}
		
		if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDet=this.userdetails.loadUserByUsername(username);
			if(jwtutil.validateToken(jwt, userDet)) {
				UsernamePasswordAuthenticationToken uspasswordTokn=new UsernamePasswordAuthenticationToken(userDet, null,userDet.getAuthorities());
				uspasswordTokn.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(uspasswordTokn);
			}
		}
		filterChain.doFilter(request, response);
	}

}
