package com.unla.grupo12.controller;

import java.util.List;

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
import com.unla.grupo12.model.PersonaModel;
import com.unla.grupo12.service.IPersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	 
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	
	@GetMapping("agregarPersona")
	public String agregarPersona() {
		ModelAndView model = new ModelAndView(ViewRouteHelper.PERSONA_AGREGAR);
		List<Persona> personas = personaService.listAllPersonas();
		model.addObject("personas", personas);
		return ViewRouteHelper.PERSONA_AGREGAR;
	}
	
	@PostMapping("agregarPersona")
	public String agregarPersona(@ModelAttribute("persona") PersonaModel personaModel) {
		personaService.agregarPersona(personaModel);
		return ViewRouteHelper.INDEX;
	}

}
