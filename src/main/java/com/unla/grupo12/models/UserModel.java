package com.unla.grupo12.models;

public class UserModel {
	
	private int id;
	
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private String email;
	private String username;
	private String password;
	
	
	
	public UserModel() {}
	
	
	public UserModel(int id, String nombre, String apellido, String tipoDocumento, String email, String username, String password) {
		
		this.setId(id);
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.email = email;
		this.username = username;
		this.password = password;
		
		
		
	}
	
	public UserModel(String nombre, String apellido, String tipoDocumento, String email, String username, String password) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.email = email;
		this.username = username;
		this.password = password;
		
		
		
	}
	
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}


