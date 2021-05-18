package com.unla.grupo12.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo12.converters.userRoleConverter;
import com.unla.grupo12.models.UserRoleModel;
import com.unla.grupo12.repositories.IUserRepository;
import com.unla.grupo12.repositories.IUserRoleRepository;
import com.unla.grupo12.services.IUserRoleService;

@Service("userRoleService")
public class UserRoleService implements IUserRoleService {

	

	@Autowired
	@Qualifier("userRoleRepository")
	private IUserRoleRepository userRoleRepository;
	
	@Autowired
	@Qualifier("userRoleConverter")
	private userRoleConverter userRoleConverter;

	
	@Override
	public boolean remove(int id) {
		
		
		try{
			userRoleRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<com.unla.grupo12.entities.UserRole> getAll() {
		
		return userRoleRepository.findAll();
		
	}

	@Override
	public UserRoleModel agregarOActualizar(UserRoleModel userRoleModel) {
		com.unla.grupo12.entities.UserRole role = userRoleRepository.save(userRoleConverter.modelToEntity(userRoleModel));
		return userRoleConverter.entityToModel(role);
	}

	
	
	
}
