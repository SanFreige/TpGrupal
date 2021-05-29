package com.TP.tpversion1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TP.tpversion1.entities.Contacto;

@Repository
public interface IContactoDao extends JpaRepository<Contacto, Long>{

}
