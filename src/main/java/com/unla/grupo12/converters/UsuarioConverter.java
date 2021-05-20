package com.unla.grupo12.converters;

import org.springframework.stereotype.Component;

import com.unla.grupo12.entity.Usuario;
import com.unla.grupo12.model.UsuarioModel;


@Component("usuarioConverter")
public class UsuarioConverter {
	
	
	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		
		return new Usuario(usuarioModel.getId(), usuarioModel.getNombre(), usuarioModel.getApellido(), usuarioModel.getNroDocumento(), 
				usuarioModel.getTipoDocumento(), usuarioModel.getEmail(), usuarioModel.getUsuario(), usuarioModel.getClave(),usuarioModel.isActivo());
	}

	public UsuarioModel entityToModel(Usuario usuario) {
		
		
		return new UsuarioModel(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getNroDocumento(), 
				usuario.getTipoDocumento(), usuario.getEmail(), usuario.getUsuario(), usuario.getClave(), usuario.isActivo());
	}

}
