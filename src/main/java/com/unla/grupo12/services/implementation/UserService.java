package com.unla.grupo12.services.implementation;

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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unla.grupo12.converters.UserConverter;
import com.unla.grupo12.entities.UserRole;
import com.unla.grupo12.models.UserModel;
import com.unla.grupo12.repositories.IUserRepository;
import com.unla.grupo12.services.IUserService;

@Service("userService")
public class UserService implements IUserService, UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private IUserRepository userRepository;

	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;

	@Override
	public UserModel agregarOActualizar(UserModel userModel) {

		com.unla.grupo12.entities.User user = userRepository.save(userConverter.modelToEntity(userModel));
		
		
		
		return userConverter.entityToModel(user);

	}

	@Override
	public boolean remove(int id) {
		try {

			userRepository.deleteById(id);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.unla.grupo12.entities.User user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		
		return buildUser(user, buildGrantedAuthorities(user.getUserRoles()));
		
	}

	private User buildUser(com.unla.grupo12.entities.User user, List<GrantedAuthority> grantedAuthorities) {
		
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, grantedAuthorities);
		
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Set<UserRole> userRoles){
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		
		for(UserRole userRole: userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}
	
	public List<com.unla.grupo12.entities.User> getAll() {

		return userRepository.findAll();
	}

}
