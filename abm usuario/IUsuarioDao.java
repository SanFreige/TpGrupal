package com.TP.tpversion1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.TP.tpversion1.entities.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u JOIN FETCH u.perfil WHERE u.username = (:username)")
	public  Usuario findByUsernameAndFetchUserRolesEagerly(@Param("username") String username);
	
	public Usuario findByUsername(String username);
	
	public Usuario findById(long id);
}
