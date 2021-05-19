package com.unla.grupo12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo12.helpers.ViewRouteHelper;




//REALIZA UN MAPEO HACIA localhost:8080/
@Controller
@RequestMapping("/")

public class HomeController {
	
	
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
	
	
	

}
