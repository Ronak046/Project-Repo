package com.gl.UserInterfaceClient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.UserInterfaceClient.bean.MyUser;
import com.gl.UserInterfaceClient.dao.MyUserRepository;


@Service
public class MyUserService implements UserDetailsService{
	@Autowired
	private MyUserRepository repository;
	private String userType;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		MyUser users=repository.findById(username).get();
		userType=users.getUserType();
		return users;
	}
	public void save(MyUser users) {
		repository.save(users);
	}
	public String getUserType() {
		return userType;
	}

}
