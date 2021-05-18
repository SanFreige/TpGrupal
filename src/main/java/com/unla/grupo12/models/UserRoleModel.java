package com.unla.grupo12.models;

import com.unla.grupo12.entities.User;

public class UserRoleModel {
	
	private int id;
	private String role;
	private User user;

	
	public UserRoleModel() {}
	
	public UserRoleModel(int id, String role, User user) {
		
		this.id = id;
		this.role = role;
		this.user = user;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
	
}
