package com.unla.grupo12.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo12.converter.PermisoConverter;
import com.unla.grupo12.converter.UsuarioConverter;
import com.unla.grupo12.entity.Permiso;
import com.unla.grupo12.entity.Usuario;
import com.unla.grupo12.model.PermisoModel;
import com.unla.grupo12.repository.IPermisoRepository;
import com.unla.grupo12.repository.IUsuarioRepository;
import com.unla.grupo12.service.IPermisoService;

@Service("permisoService")
public class PermisoImpl implements IPermisoService{

	
	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;

	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;
	
	

}
