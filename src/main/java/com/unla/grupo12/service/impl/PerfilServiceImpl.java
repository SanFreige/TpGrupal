package com.unla.grupo12.service.impl;

import com.unla.grupo12.converters.PerfilConverter;
import com.unla.grupo12.entity.Perfil;
import com.unla.grupo12.model.PerfilModel;
import com.unla.grupo12.repository.IPerfilRepository;
import com.unla.grupo12.service.IPerfilService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("perfilService")
public class PerfilServiceImpl implements IPerfilService {
	
	
	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	
	
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;
	

	@Override
	public List<Perfil> getAll(){
		
		return perfilRepository.findAll();
		
	}


	// IMPLEMENTACION DEL SERVICIO PARA AGREGAR UN PerfilModel A LA BD 
	 
	@Override
	public PerfilModel agregarOActualizar(PerfilModel perfilModel) {
		
		Perfil p = perfilRepository.save(perfilConverter.modelToEntity(perfilModel));
		
		return perfilConverter.entityToModel(p);
	}
	
	
	
	
	
}
