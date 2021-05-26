package com.unla.grupo12.model;

import com.unla.grupo12.entity.Perfil;
import lombok.Data;

@Data
public class UsuarioModel {

	private Long id;
	private String nombre;
	private String apellido;
	private Long nroDocumento;
	private String tipoDocumento;
	private String email;
	private String usuario;
	private String clave;
	private boolean activo;
	private Perfil perfil;
	
	public UsuarioModel() {}

	public UsuarioModel(Long id, String nombre, String apellido, Long nroDocumento, String tipoDocumento, String email,
			String usuario, String clave, boolean activo) {
		
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroDocumento = nroDocumento;
		this.tipoDocumento = tipoDocumento;
		this.email = email;
		this.usuario = usuario;
		this.setClave(clave);
		this.setActivo(true);  //AL MOMENTO DE AGREGAR UN USUARIO SETEA ESTE VALOR COMO TRUE
		
	}

}
