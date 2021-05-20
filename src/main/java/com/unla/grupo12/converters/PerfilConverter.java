package com.unla.grupo12.converters;

import org.springframework.stereotype.Component;

import com.unla.grupo12.entity.Perfil;
import com.unla.grupo12.entity.Usuario;
import com.unla.grupo12.model.PerfilModel;
import com.unla.grupo12.model.UsuarioModel;


@Component("perfilConverter")
public class PerfilConverter {

	public Perfil modelToEntity(PerfilModel perfilModel) {

		return new Perfil(perfilModel.getId(), perfilModel.getNombre());
	}

	public PerfilModel entityToModel(Perfil perfil) {

		return new PerfilModel(perfil.getId(), perfil.getNombre());
	}
}
