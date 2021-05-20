package com.unla.grupo12.service.impl;

import com.unla.grupo12.converters.UsuarioConverter;
import com.unla.grupo12.entity.Perfil;
import com.unla.grupo12.entity.Usuario;
import com.unla.grupo12.model.UsuarioModel;
import com.unla.grupo12.repository.IUsuarioRepository;
import com.unla.grupo12.service.IUsuarioService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("usuarioService")
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {

	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;

	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;

	@Override
	public UsuarioModel agregarOActualizar(UsuarioModel usuarioModel) {

		Usuario usuario = usuarioRepository.save(usuarioConverter.modelToEntity(usuarioModel));

		return usuarioConverter.entityToModel(usuario);
	}

	@Override
	public List<Usuario> getAll() {

		return usuarioRepository.findAll();

	}

	
	
	
	/*
	 * 
	 *  METODOS PARA EL INICIO DE SESION 
	 *  
	 */
	
	
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByNombreUsuarioYPerfil(nombreUsuario);

		return buildUser(usuario, buildGrantedAuthorities(usuario.getPerfiles()));
	}

	private User buildUser(Usuario usuario, List<GrantedAuthority> grantedAuthorities) {

		return new User(usuario.getUsuario(), usuario.getClave(), usuario.isActivo(), true, true, true, // accountNonExpired,
																										// credentialsNonExpired,
																										// accountNonLocked
				grantedAuthorities);

	}

	private List<GrantedAuthority> buildGrantedAuthorities(Set<Perfil> perfiles) {

		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

		for (Perfil p : perfiles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(p.getNombre()));
		}

		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}

}
