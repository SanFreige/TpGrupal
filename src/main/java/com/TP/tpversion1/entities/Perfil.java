package com.TP.tpversion1.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="perfil")
public class Perfil {
	//atributos
		@Id
		@GeneratedValue
		private long id;
		
		@Column(name="rol")
		private String rol;
		
		@OneToOne(fetch = FetchType.LAZY)
		private Usuario usuario;
		
		public Perfil() {}

		public Perfil(int id, String rol) {
			super();
			this.id = id;
			this.rol = rol;
		}

		public long getId() {
			return this.id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

	
		
		
}
