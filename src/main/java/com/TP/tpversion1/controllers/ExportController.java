package com.TP.tpversion1.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TP.tpversion1.entities.Perfil;
import com.TP.tpversion1.entities.Usuario;
import com.TP.tpversion1.export.PerfilPDFExporter;
import com.TP.tpversion1.export.UserPDFExporter;
import com.TP.tpversion1.service.IPerfilService;
import com.TP.tpversion1.service.IUsuarioService;
import com.lowagie.text.DocumentException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/export")
public class ExportController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IPerfilService perfilService;
	
	
	@GetMapping("/pdfusuarios")
	public void UsuarioexportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf"); //para que el browser lo identifique como un .pdf
		DateFormat date = new SimpleDateFormat("dd-MM-yyyy"); //El formato del nombre con el cual se va a descargar 
		String fechaCreacion = date.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=usuarios_"+fechaCreacion+".pdf";//nombre del archivo
		
		response.setHeader(headerKey, headerValue);
		
		List<Usuario> listUsuarios = usuarioService.listAllUsuario();
		
		UserPDFExporter exporter = new UserPDFExporter(listUsuarios);
		exporter.export(response);
	}
	
	@GetMapping("/pdfperfil")
	public void PerfilexportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf"); //para que el browser lo identifique como un .pdf
		DateFormat date = new SimpleDateFormat("dd-MM-yyyy"); //El formato del nombre con el cual se va a descargar 
		String fechaCreacion = date.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=perfiles_"+fechaCreacion+".pdf";//nombre del archivo
		
		response.setHeader(headerKey, headerValue);
		
		List<Perfil> listPerfil = perfilService.listAllPerfil();
		
		PerfilPDFExporter exporter = new PerfilPDFExporter(listPerfil);
		exporter.export(response);
	}
}
