package com.TP.tpversion1.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="contacto")
public class Contacto {
	@Id
	@GeneratedValue
	@Column(name="idContacto")
	private long idContacto;
	
	@Column(name="email")
	private String email;
	
	@OneToOne
	@JoinColumn(name = "FK_USUARIO", updatable = false, nullable = false)
	private Usuario usuario;
	
	public Contacto() {}

	public Contacto(long idContacto, String email, Usuario usuario) {
		super();
		this.idContacto = idContacto;
		this.email = email;
		this.usuario = usuario;
	}

	public long getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
