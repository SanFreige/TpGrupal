package com.TP.tpversion1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TP.tpversion1.entities.Perfil;
import com.TP.tpversion1.entities.Usuario;
import com.TP.tpversion1.helpers.ViewRouteHelper;
import com.TP.tpversion1.service.IContactoService;
import com.TP.tpversion1.service.IPerfilService;
import com.TP.tpversion1.service.IUsuarioService;

@Controller
@RequestMapping("/asignar")
public class AsignarController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IPerfilService perfilService;

	
	private Perfil perfil=null;
	private Usuario usuario=null;
	
	
	//***************ASIGNAR USUARIO A PERFIL*****************
	@GetMapping("/elejirusuario")
	public String formUsuario(Model model, @RequestParam(name="id", required = true) long id) {		
		if(id != 0)
			this.perfil = perfilService.findPerfilById(id);
		model.addAttribute("usuarios", usuarioService.listAllUsuario());
		return ViewRouteHelper.FORM_USUARIO_ASIGNAR;
	}
	
	@GetMapping("/asignarusuario")
	public String addUsuario(@RequestParam(name="id", required = true) long id) {		
		if (id != 0)
			this.usuario = usuarioService.findUsuarioById(id);
		this.perfil.setUsuario(this.usuario);
		perfilService.addPerfil(perfil);
		
		if(this.perfil != null && id != 0) {
			this.usuario.setPerfil(perfil)	;
			usuarioService.registrar(this.usuario);
		}
		
		this.usuario = null;
		this.perfil = null;
		return ViewRouteHelper.INDEX;
		
		
	}
}
