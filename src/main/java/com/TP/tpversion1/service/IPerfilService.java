package com.TP.tpversion1.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.TP.tpversion1.entities.Perfil;
import com.TP.tpversion1.entities.Usuario;

public interface IPerfilService {

	public List<Perfil> listAllPerfil();
	
	public  Perfil addPerfil(Perfil perfil);
	
	public boolean  remove(long id);
	
	public Perfil findPerfilById(long id);
	
	public  Usuario findByUsernameAndFetchUserRolesEagerly(@Param("id") long id);
}
