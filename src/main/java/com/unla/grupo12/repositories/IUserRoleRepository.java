package com.unla.grupo12.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo12.entities.User;
import com.unla.grupo12.entities.UserRole;


@Repository("userRoleRepository")
public interface IUserRoleRepository extends  JpaRepository<UserRole, Serializable>{
	
	@Query("SELECT u FROM UserRole u JOIN FETCH u.user WHERE u.role = (:role)")
	public abstract UserRole findByRoles(@Param("role") String role);
	
	
	public abstract UserRole findByRole(String role);
	public abstract UserRole findById(int id);


}
