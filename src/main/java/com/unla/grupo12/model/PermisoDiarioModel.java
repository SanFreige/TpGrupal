package com.unla.grupo12.model;

import java.time.LocalDate;
import java.util.Set;

public class PermisoDiarioModel extends PermisoModel {

  private String motivo;

  public PermisoDiarioModel(int idPermiso, PersonaModel pedido, LocalDate fecha, Set<LugarModel> desdeHasta, String motivo) {
    super(idPermiso, pedido, fecha, desdeHasta);
    this.motivo = motivo;
  }

  public PermisoDiarioModel() {
  }


  public PermisoDiarioModel(String motivo) {
    this.motivo = motivo;
  }

  public String getMotivo() {
    return motivo;
  }

  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }

  @Override
  public String toString() {
    return "PermisoDiario{" +
        "motivo='" + motivo + '\'' +
        '}';
  }
}
