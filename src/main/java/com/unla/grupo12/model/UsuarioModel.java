package com.unla.grupo12.model;


import com.unla.grupo12.entity.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

  private Long id;
  private String nombre;
  private String apellido;
  private Long nroDocumento;
  private String tipoDocumento;
  private String email;
  private String usuario;
  private String clave;
  private Perfil Perfil;

}


