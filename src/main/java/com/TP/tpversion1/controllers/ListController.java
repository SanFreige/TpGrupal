package com.TP.tpversion1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TP.tpversion1.service.IPerfilService;
import com.TP.tpversion1.service.IUsuarioService;

@Controller
@RequestMapping("/list")
public class ListController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IPerfilService perfilService;
	
	
	@GetMapping("/listusuarios")
	public ModelAndView listAllUsuarios() {
		
		ModelAndView mav = new ModelAndView("listusuario");
		mav.addObject("usuarios", usuarioService.listAllUsuario());
		return mav;
	}
	
	@GetMapping("/listperfiles")
	public ModelAndView listAllPerfiles() {
		
		ModelAndView mav = new ModelAndView("listperfiles");
		mav.addObject("perfiles", perfilService.listAllPerfil() );
		return mav;
	}
	
	
}
