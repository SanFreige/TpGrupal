package com.unla.grupo12.controller;

import com.unla.grupo12.helpers.ViewRouteHelper;
import com.unla.grupo12.model.PerfilModel;
import com.unla.grupo12.model.UsuarioModel;
import com.unla.grupo12.service.PerfilService;
import com.unla.grupo12.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;


//REALIZA UN MAPEO HACIA localhost:8080/
@Controller
@RequestMapping("/")

public class HomeController {

  @Autowired
  private UsuarioService usuarioService;

  @Autowired
  private PerfilService perfilService;


  //CARGA LA PRIMER PAGINA, EN ESTE CASO EL index
  @GetMapping("")
  public String index() {

    return ViewRouteHelper.INDEX;

  }

  @GetMapping("about")
  public String about() {

    return ViewRouteHelper.ABOUT;

  }

  @GetMapping("services")
  public String services() {

    return ViewRouteHelper.SERVICES;

  }

  @GetMapping("contact")
  public String contact() {

    return ViewRouteHelper.CONTACT;

  }

  @GetMapping("/lista-usuario")
  public List<UsuarioModel> listaUsuario() {
    List<UsuarioModel> list = usuarioService.listUsuarios();
    return list;
  }

  @GetMapping("/lista-perfil")
  public List<PerfilModel> listaPerfil() {
    List<PerfilModel> list = perfilService.listPerfil();
    return list;
  }

  @GetMapping(value = "/perfiles", produces = MediaType.APPLICATION_PDF_VALUE)
  public ResponseEntity<InputStreamResource> perfilReporte()
      throws IOException {
    ByteArrayInputStream pdf = perfilService.generacionPdf();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "inline; filename=ListaPerfiles.pdf");
    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
        .body(new InputStreamResource(pdf));
  }

  @GetMapping(value = "/usuarios", produces = MediaType.APPLICATION_PDF_VALUE)
  public ResponseEntity<InputStreamResource> usuarioReporte()
      throws IOException {
    ByteArrayInputStream pdf = usuarioService.generacionPdf();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "inline; filename=ListaUsuarios.pdf");
    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
        .body(new InputStreamResource(pdf));
  }
}
