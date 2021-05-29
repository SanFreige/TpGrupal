package com.TP.tpversion1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.tpversion1.dao.IPerfilDao;
import com.TP.tpversion1.entities.Perfil;
import com.TP.tpversion1.entities.Usuario;
import com.TP.tpversion1.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService{

	@Autowired
	private IPerfilDao perfilDao; 
	
	@Override
	public List<Perfil> listAllPerfil() {
		return perfilDao.findAll();
	}

	@Override
	public Perfil addPerfil(Perfil perfil) {
		return perfilDao.save(perfil);
	}

	@Override
	public boolean remove(long id) {
		try {
			Perfil perfil = this.findPerfilById(id);
			perfilDao.delete(perfil);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	@Override
	public Perfil findPerfilById(long id) {
		return perfilDao.findById(id);
	}

	@Override
	public Usuario findByUsernameAndFetchUserRolesEagerly(long id) {
		return perfilDao.findByUsernameAndFetchUserRolesEagerly(id);
	}

}
