package com.TP.tpversion1.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.TP.tpversion1.entities.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
	
	public Usuario registrar(Usuario u);
	
	public  List<Usuario> listAllUsuario();
	
	public abstract Usuario findUsuarioById(long id);
	
	public boolean remove(long id);
	
	public  Usuario findByUsernameAndFetchUserRolesEagerly(@Param("username") String username);
}
