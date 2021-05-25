package com.unla.grupo12.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.unla.grupo12.entity.Perfil;
import com.unla.grupo12.model.PerfilModel;

public interface IPerfilService{

	
	public PerfilModel agregarOActualizar(PerfilModel perfilModel);
	public List<Perfil> getAll();
	
	List<PerfilModel> listPerfil();
	public ByteArrayInputStream generacionPdf ();
	
	

}
