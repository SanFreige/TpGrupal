package com.unla.grupo12.service;

import com.unla.grupo12.model.PerfilModel;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface PerfilService{

  List<PerfilModel> listPerfil();

  ByteArrayInputStream generacionPdf ();

}
