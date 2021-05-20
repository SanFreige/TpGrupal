package com.unla.grupo12.repository;

import com.unla.grupo12.entity.Usuario;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {
	
	
	@Query("SELECT u FROM Usuario u JOIN FETCH u.perfiles WHERE u.usuario = (:nombreUsuario)")
	public abstract Usuario findByNombreUsuarioYPerfil(@Param("nombreUsuario") String nombreUsurio); 
	
	public abstract Usuario findById(long id);
	
	public abstract Usuario findByUsuario(String usuario);

}
