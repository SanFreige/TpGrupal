package com.unla.grupo12.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo12.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")

public class HomeController {
	
	
	//Solo se puede acceder al index con un usuario que tenga como perfil Admin
	
	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/")
	public String index() {
		
		return ViewRouteHelper.INDEX;
		
	}
	
	
	@GetMapping("login")
	public String login(Model model, @RequestParam(name = "error", required = false) String error, @RequestParam(name = "logout", required = false) String logout) {

		model.addAttribute("error", error);
		model.addAttribute("logout", logout);

		return ViewRouteHelper.LOGIN;

	}

	@GetMapping("/logout")
	public String logout(Model model) {

		return ViewRouteHelper.LOGOUT;

	}

	@GetMapping("/loginsuccess")
	public String loginCheck(Model model) {

		return ViewRouteHelper.INDEX;

	}
	
	
	

}
