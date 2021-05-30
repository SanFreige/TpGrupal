package com.unla.grupo12.model;

public class PersonaModel {

  private int idPersona;
  private String nombre;
  private String apellido;
  private long dni;

  public PersonaModel(int idPersona, String nombre, String apellido, long dni) {
    this.idPersona = idPersona;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  public PersonaModel() {
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

  @Override
  public String toString() {
    return "Persona{" +
        "idPersona=" + idPersona +
        ", nombre='" + nombre + '\'' +
        ", apellido='" + apellido + '\'' +
        ", dni=" + dni +
        '}';
  }
}
