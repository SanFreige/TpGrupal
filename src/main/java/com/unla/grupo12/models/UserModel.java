package com.unla.grupo12.models;

import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class UserModel {

	private int id;

	private String username;

	
	@Size(min=8)
	private String password;

	public UserModel() {
	}

	public UserModel(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.setPassword(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		this.password = pe.encode(password);
	}

}
