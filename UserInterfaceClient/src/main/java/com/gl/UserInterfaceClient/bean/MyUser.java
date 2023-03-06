package com.gl.UserInterfaceClient.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Entity
public class MyUser extends User{
	@Id
	private String username;
	private String password;
	private String emailId;
	private String userType;
	public MyUser() {
		super("Marigold","Mango",new ArrayList<>());
	}
	
	public MyUser(String username, String password, String userType, Collection<? extends GrantedAuthority> authorities,
			String username2, String password2, String userType2) {
		super(username, password, authorities);
		username = username2;
		password = password2;
	    userType = userType2;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "MyUser [username=" + username + ", password=" + password + ", emailId=" + emailId + ", userType="
				+ userType + "]";
	}
}