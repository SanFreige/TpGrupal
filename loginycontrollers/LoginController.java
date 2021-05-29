package com.TP.tpversion1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.TP.tpversion1.entities.Usuario;
import com.TP.tpversion1.service.IUsuarioService;



@Controller
public class LoginController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/auth/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login3";
	}
	
	@GetMapping("/auth/registro")
	public String registroForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}
	
	@PostMapping("/auth/registro2")
	public String registro( @ModelAttribute Usuario usuario, BindingResult result, Model model) {
		String direccion;
		if(result.hasErrors()) {
			direccion = "redirect:/auth/registro";
		}
		else {
			model.addAttribute("usuario", usuarioService.registrar(usuario));
			direccion = "redirect:/private/index";
		}
		return direccion;		
	}
}
