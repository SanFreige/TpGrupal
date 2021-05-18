package com.unla.grupo12.services;

import java.util.List;

import com.unla.grupo12.entities.UserRole;
import com.unla.grupo12.models.UserRoleModel;


public interface IUserRoleService {
	
	public UserRoleModel agregarOActualizar(UserRoleModel userRoleModel);
	
	public boolean remove (int id);

	public List<UserRole> getAll();
}
