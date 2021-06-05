package com.unla.grupo12.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "permiso")
public class Permiso implements java.io.Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int idPermiso;
  @ManyToOne
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinColumn(name = "persona_id")
  protected Persona pedido;
  protected LocalDate fecha;
  @ManyToMany
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinColumn(name = "lugar_id")
  protected Set<Lugar> desdeHasta;

  public Permiso(int idPermiso, Persona pedido, LocalDate fecha, Set<Lugar> desdeHasta) {
    this.idPermiso = idPermiso;
    this.pedido = pedido;
    this.fecha = fecha;
    this.desdeHasta = desdeHasta;
  }

  public Permiso() {
  }

  public int getIdPermiso() {
    return idPermiso;
  }

  public void setIdPermiso(int idPermiso) {
    this.idPermiso = idPermiso;
  }

  public Persona getPedido() {
    return pedido;
  }

  public void setPedido(Persona pedido) {
    this.pedido = pedido;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public Set<Lugar> getDesdeHasta() {
    return desdeHasta;
  }

  public void setDesdeHasta(Set<Lugar> desdeHasta) {
    this.desdeHasta = desdeHasta;
  }

  @Override
  public String toString() {
    return "Permiso{" +
        "idPermiso=" + idPermiso +
        ", pedido=" + pedido +
        ", fecha=" + fecha +
        ", desdeHasta=" + desdeHasta +
        '}';
  }
}
