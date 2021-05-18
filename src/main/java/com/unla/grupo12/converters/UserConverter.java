package com.unla.grupo12.converters;


import org.springframework.stereotype.Component;

import com.unla.grupo12.entities.User;
import com.unla.grupo12.models.UserModel;

@Component("userConverter")
public class UserConverter {
	
	public UserModel entityToModel(User user) {
		
		return new UserModel(user.getId(), user.getUsername(), user.getPassword());
		
	}
	
	
	public User modelToEntity (UserModel userModel) {
		
		return new User(userModel.getId(), userModel.getUsername(), userModel.getPassword());
		
	}




}
