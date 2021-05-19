package com.unla.grupo12.repository;

import com.unla.grupo12.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Long> {

}
