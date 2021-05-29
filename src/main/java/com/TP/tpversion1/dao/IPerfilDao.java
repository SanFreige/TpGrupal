package com.TP.tpversion1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TP.tpversion1.entities.Perfil;
import com.TP.tpversion1.entities.Usuario;

@Repository
public interface IPerfilDao extends JpaRepository<Perfil, Long>{

	@Query("SELECT p FROM Perfil p JOIN FETCH p.usuario WHERE p.id = (:id)")
	public  Usuario findByUsernameAndFetchUserRolesEagerly(@Param("id") long id);
	
	public Perfil findById(long id);
}
