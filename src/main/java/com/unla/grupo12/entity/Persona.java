package com.unla.grupo12.entity;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idPersona;
  private String nombre;
  private String apellido;
  private long dni;

  public Persona(int idPersona, String nombre, String apellido, long dni) {
    this.idPersona = idPersona;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  public Persona() {
  }

  public int getIdPersona() {
    return idPersona;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public long getDni() {
    return dni;
  }

  public void setIdPersona(int idPersona) {
    this.idPersona = idPersona;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setDni(long dni) {
    this.dni = dni;
  }

}
