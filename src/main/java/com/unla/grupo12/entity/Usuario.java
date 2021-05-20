package com.unla.grupo12.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private Long nroDocumento;
	private String tipoDocumento;
	private String email;
	private String usuario;
	private String clave;
	@ManyToOne
	private Perfil perfil;
}
