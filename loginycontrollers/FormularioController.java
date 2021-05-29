package com.TP.tpversion1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TP.tpversion1.entities.Contacto;
import com.TP.tpversion1.entities.Perfil;
import com.TP.tpversion1.entities.Usuario;
import com.TP.tpversion1.helpers.ViewRouteHelper;
import com.TP.tpversion1.service.IContactoService;
import com.TP.tpversion1.service.IPerfilService;
import com.TP.tpversion1.service.IUsuarioService;

@Controller
@RequestMapping("/form")
public class FormularioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired	
	private IPerfilService perfilService;
	
	@Autowired	
	private IContactoService contactoService;
	
	private Perfil perfil=null;
	private Usuario usuario=null;
	private Contacto contacto= null;
	
	//*************************** USUARIOS*************
	@GetMapping("/formusuario")
	public String formUsuario(Model model, @RequestParam(name="id", required = true) int id) {
		Usuario usuario = new Usuario();
		if(id != 0)
			usuario = usuarioService.findUsuarioById(id);
		model.addAttribute("usuarios", usuario);
		return ViewRouteHelper.FORM_USUARIO;
	}
	
	@PostMapping("/addusuario")
	public String addUsuario(@ModelAttribute(name="usuario") Usuario usuario) {
		//usuario.setPerfil(this.perfil);
		this.usuario = usuario;
		usuarioService.registrar(usuario);
		return "redirect:/form/formcontacto";
	}
	
	@GetMapping("/formusuariomodificar")
	public String formUsuarioModificar(Model model, @RequestParam(name="id", required = true) int id) {
		Usuario usuario = new Usuario();
		if(id != 0)
			usuario = usuarioService.findUsuarioById(id);
		model.addAttribute("usuarios", usuario);
		return ViewRouteHelper.FORM_USUARIO_MOD;
	}
	@PostMapping("/modificarusuario")
	public String modificarUsuario(@ModelAttribute(name="usuario") Usuario usuario) {
		this.usuario = usuario;
		usuarioService.registrar(usuario);
		return ViewRouteHelper.INDEX;
	}
	
	@GetMapping("/removeusuario")
	public String removeUsuario(@RequestParam(name="id", required = true) long id) {
		usuarioService.remove(id);
		return ViewRouteHelper.INDEX;
	}
	
	//************************CONTACTOS*****************
	@GetMapping("/formcontacto")
	public String formContacto(Model model) {
		model.addAttribute("contacto", new Contacto());		
		return ViewRouteHelper.FORM_CONTACTO;
	}
	
	@PostMapping("/addcontacto")
	public String addContacto(@ModelAttribute(name="contacto") Contacto contacto) {
		contacto.setUsuario(this.usuario);
		//this.usuario.setContacto(contacto);		
		contactoService.addContacto(contacto);
		//usuarioService.registrar(this.usuario);
		this.usuario = null;
		return ViewRouteHelper.INDEX;
	}
	
	//************************PERFILES*********************
	@GetMapping("/formperfil")
	public String formPerfil(Model model, @RequestParam(name="id", required = true) long id) {	
		if(id != 0)
			this.usuario = usuarioService.findUsuarioById(id);
		model.addAttribute("perfil", new Perfil());		
		return ViewRouteHelper.FORM_PERFIL;
	}
	
	@PostMapping("/addperfil")
	public String addPerfil(@ModelAttribute(name="perfil") Perfil perfil) {		
		if(this.usuario != null) {
			perfil.setUsuario(this.usuario);			
		}
		perfilService.addPerfil(perfil);
		
		if(this.usuario != null) {
			this.usuario.setPerfil(perfil)	;
			usuarioService.registrar(this.usuario);
		}
		this.usuario = null;
		return ViewRouteHelper.INDEX;
	}
	
	@GetMapping("/removeperfil")
	public String removePerfil(@RequestParam(name="id", required = true) int id) {
		perfilService.remove(id);
		return ViewRouteHelper.INDEX;
	}
	
	@GetMapping("/formperfilmodificar")
	public String formPerfilModificar(Model model, @RequestParam(name="id", required = true) int id) {
		Perfil perfil = new Perfil();
		if(id != 0)
			perfil = perfilService.findPerfilById(id);
		model.addAttribute("perfil", perfil);
		return ViewRouteHelper.FORM_PERFIL;
	}
	
	//**************************REDIRECCION**************************
		@GetMapping("/redirectindex")
		public String redirectIndex() {
			return ViewRouteHelper.INDEX;
		}
		
	
		
		
}
