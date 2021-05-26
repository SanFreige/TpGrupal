package com.unla.grupo12.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.unla.grupo12.entity.Usuario;
import com.unla.grupo12.model.UsuarioModel;

public interface IUsuarioService {
	
	
	 UsuarioModel agregarOActualizar(UsuarioModel usuarioModel);
	 List<Usuario> getAll();
	 UsuarioModel findById(Long id);
	 boolean darDeBaja(Long id);
	
	List<UsuarioModel> listUsuarios ();
	ByteArrayInputStream generacionPdf ();
	
}
