package com.unla.grupo12.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo12.entities.User;
import com.unla.grupo12.vistas.RuteoVistas;

@Controller
@RequestMapping("")
public class HomeController {


	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("")
	public String index() {
		
		
		return RuteoVistas.INDEX;
	}

	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/index")
	public String toIndex() {
		
		
		return RuteoVistas.INDEX;
	}
	
	
	
	
	
		
	
}
