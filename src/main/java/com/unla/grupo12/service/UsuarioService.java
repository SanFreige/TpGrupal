package com.unla.grupo12.service;

import com.unla.grupo12.model.UsuarioModel;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface UsuarioService {

  List<UsuarioModel> listUsuarios ();

  ByteArrayInputStream generacionPdf ();
}
