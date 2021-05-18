package com.unla.grupo12.converters;

import org.springframework.stereotype.Component;

import com.unla.grupo12.entities.UserRole;
import com.unla.grupo12.models.UserRoleModel;

@Component("userRoleConverter")
public class userRoleConverter {


	public UserRoleModel entityToModel(UserRole userRole) {
		
		return new UserRoleModel(userRole.getId(), userRole.getRole(), userRole.getUser());
		
	}
	
	
	public UserRole modelToEntity(UserRoleModel userRoleModel) {
		
		return new UserRole(userRoleModel.getId(), userRoleModel.getUser(), userRoleModel.getRole());
		
	}
	
}
