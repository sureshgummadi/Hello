package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.catalina.Role;
import org.apache.catalina.UserDatabase;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService{
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	MyUserDetails l=new MyUserDetails();
	l.loadAdminName("admin");
	return new User("subbu","subbu1008",(Collection<? extends GrantedAuthority>) l);
}

public Role loadAdminName(String adminname) throws UsernameNotFoundException{
	
	return new Role() {
		
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void setRolename(String rolename) {
		
			
		}
		
		@Override
		public void setDescription(String description) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public UserDatabase getUserDatabase() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getRolename() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}
	};
}
}
