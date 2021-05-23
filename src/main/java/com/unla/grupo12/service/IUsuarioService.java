package com.unla.grupo12.service;

import java.util.List;

import com.unla.grupo12.entity.Usuario;
import com.unla.grupo12.model.UsuarioModel;

public interface IUsuarioService {
	
	
	public UsuarioModel agregarOActualizar(UsuarioModel usuarioModel);
	public List<Usuario> getAll();
	public UsuarioModel findById(Long id);
	
	
}
