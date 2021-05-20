package com.unla.grupo12.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "perfil")
public class Perfil {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
}
