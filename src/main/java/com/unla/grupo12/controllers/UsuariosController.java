package com.unla.grupo12.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo12.entities.User;
import com.unla.grupo12.entities.UserRole;
import com.unla.grupo12.models.UserModel;
import com.unla.grupo12.models.UserRoleModel;
import com.unla.grupo12.services.IUserRoleService;
import com.unla.grupo12.services.IUserService;
import com.unla.grupo12.vistas.RuteoVistas;

@Controller
@RequestMapping("usuarios")
public class UsuariosController {

	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	@Autowired
	@Qualifier("userRoleService")
	private IUserRoleService userRoleService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView modelo = new ModelAndView("home/usuarios");
		List<User> usuarios = userService.getAll();
		List<UserRole> roles = userRoleService.getAll();

		modelo.addObject("users", usuarios);
		modelo.addObject("user", new UserModel());

		modelo.addObject("roles", roles);
		modelo.addObject("rol", new UserRole());
		
		return modelo;

	}

	@GetMapping("agregar")
	public ModelAndView agregarPage() {

		ModelAndView modelo = new ModelAndView();

		modelo.setViewName("home/agregar");
		modelo.addObject("user", new UserModel());

		List<UserRole> roles = userRoleService.getAll();

		modelo.addObject("roles", roles);

		return modelo;

	}

	@PostMapping("agregar")
	public ModelAndView agregarUserABd(@ModelAttribute("user") UserModel userModel) {

		ModelAndView modelo = new ModelAndView();

		modelo.setViewName(RuteoVistas.INDEX);

		modelo.setViewName("home/agregar");
		userService.agregarOActualizar(userModel);

		return modelo;
	}

}
