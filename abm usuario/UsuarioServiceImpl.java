package com.TP.tpversion1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.TP.tpversion1.dao.IUsuarioDao;
import com.TP.tpversion1.entities.Usuario;
import com.TP.tpversion1.service.IUsuarioService;



@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}
	
	@Override
	public Usuario registrar(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return usuarioDao.save(u);
	}

	@Override
	public List<Usuario> listAllUsuario() {
		return usuarioDao.findAll();
	}
	
	@Override
	public boolean remove(long id) {
		try {
			Usuario usuario = this.findUsuarioById(id);
			usuarioDao.delete(usuario);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Usuario findUsuarioById(long id) {
		return usuarioDao.findById(id);
	}

	@Override
	public Usuario findByUsernameAndFetchUserRolesEagerly(String username) {
		return usuarioDao.findByUsernameAndFetchUserRolesEagerly(username);
	}
}
