package com.TP.tpversion1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.tpversion1.dao.IContactoDao;
import com.TP.tpversion1.entities.Contacto;
import com.TP.tpversion1.service.IContactoService;

@Service
public class ContactoServiceImpl implements IContactoService{

	@Autowired
	private IContactoDao contactoDao;

	@Override
	public Contacto addContacto(Contacto contacto) {
		return contactoDao.save(contacto);
	}



}
