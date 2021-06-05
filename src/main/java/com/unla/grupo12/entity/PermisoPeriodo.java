package com.unla.grupo12.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class PermisoPeriodo extends Permiso {

  private int cantDias;
  private boolean vacaciones;
  @ManyToOne
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinColumn(name = "rodado_id")
  private Rodado rodado;

  public PermisoPeriodo(int cantDias, boolean vacaciones, Rodado rodado) {
    this.cantDias = cantDias;
    this.vacaciones = vacaciones;
    this.rodado = rodado;
  }

  public PermisoPeriodo() {
  }

  public int getCantDias() {
    return cantDias;
  }

  public void setCantDias(int cantDias) {
    this.cantDias = cantDias;
  }

  public boolean isVacaciones() {
    return vacaciones;
  }

  public void setVacaciones(boolean vacaciones) {
    this.vacaciones = vacaciones;
  }

  public Rodado getRodado() {
    return rodado;
  }

  public void setRodado(Rodado rodado) {
    this.rodado = rodado;
  }



}
