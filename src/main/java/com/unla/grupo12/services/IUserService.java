package com.unla.grupo12.services;

import java.util.List;

import com.unla.grupo12.entities.User;
import com.unla.grupo12.models.UserModel;

public interface IUserService {

	public UserModel agregarOActualizar(UserModel userModel);
	
	public boolean remove (int id);

	public List<User> getAll();
}
