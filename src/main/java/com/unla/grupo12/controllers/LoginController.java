package com.unla.grupo12.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo12.entities.User;
import com.unla.grupo12.models.UserModel;
import com.unla.grupo12.services.IUserService;
import com.unla.grupo12.vistas.RuteoVistas;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {

		model.addAttribute("error", error);
		model.addAttribute("logout", logout);

		return "home/login";

	}

	@GetMapping("/logout")
	public String logout(Model model) {

		return "home/logout";

	}

	@GetMapping("/loginsuccess")
	public String loginCheck(Model model) {

		return "redirect:/index";

	}

}
