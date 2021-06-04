package com.unla.grupo12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo12.entity.Persona;
import com.unla.grupo12.helpers.ViewRouteHelper;
import com.unla.grupo12.model.PermisoModel;
import com.unla.grupo12.model.PersonaModel;
import com.unla.grupo12.service.IPersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	 
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	private Persona persona;
	
	@GetMapping("/agregarPersona")
	public ModelAndView agregarPersona() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.PERSONA_AGREGAR);
		model.addObject("persona", new Persona());
		return model;
	}
	
	@PostMapping("/agregarPer")
	public String agregarPersona(@ModelAttribute("persona") PersonaModel personaModel) {
		personaService.agregarPersona(personaModel);
		return ViewRouteHelper.PERSONAS;
	}
	
	@GetMapping("/permisoPersona")
	public ModelAndView traerPermiso() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.PERMISO_X_PERSONA);
		model.addObject("persona", persona.getDni());
		return model;
	}
	
	@PostMapping("/permisoPer")
	public String traerPermiso(@ModelAttribute("persona") PersonaModel personaModel) {
		personaService.findByDni(personaModel.getDni());
		return ViewRouteHelper.PERMISO_X_PERSONA;
	}

}
