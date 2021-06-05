package com.unla.grupo12.converter;

import com.unla.grupo12.entity.PermisoPeriodo;
import com.unla.grupo12.model.PermisoPeriodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("permisoPeriodoConverter")
public class PermisoPeriodoConverter {

  @Autowired
  private RodadoConverter rodadoConverter;

  public List<PermisoPeriodoModel> listPermisoPeriodoModel(List<PermisoPeriodo> listPermisoPeriodo) {

    List<PermisoPeriodoModel> permisoPeriodoModelList = new ArrayList<PermisoPeriodoModel>();

    for (PermisoPeriodo p : listPermisoPeriodo) {
      PermisoPeriodoModel permisoPeriodoModel = new PermisoPeriodoModel();
      permisoPeriodoModel.setCantDias(p.getCantDias());
      permisoPeriodoModel.setVacaciones(p.isVacaciones());
      permisoPeriodoModel.setRodado(rodadoConverter.entityToModel(p.getRodado()));
      permisoPeriodoModelList.add(permisoPeriodoModel);
    }
    return permisoPeriodoModelList;
  }

  public List<PermisoPeriodo> listPermisoPeriodo(List<PermisoPeriodoModel> listPermisoPeriodoModel) {

    List<PermisoPeriodo> permisoPeriodoList = new ArrayList<PermisoPeriodo>();

    for (PermisoPeriodoModel p : listPermisoPeriodoModel) {
      PermisoPeriodo permisoPeriodo = new PermisoPeriodo();
      permisoPeriodo.setCantDias(p.getCantDias());
      permisoPeriodo.setVacaciones(p.isVacaciones());
      permisoPeriodo.setRodado(rodadoConverter.modelToEntity(p.getRodado()));
      permisoPeriodoList.add(permisoPeriodo);
    }
    return permisoPeriodoList;
  }

  public PermisoPeriodo modelToEntity(PermisoPeriodoModel permisoPeriodoModel) {

    return new PermisoPeriodo(permisoPeriodoModel.getCantDias(), permisoPeriodoModel.isVacaciones(),
        rodadoConverter.modelToEntity(permisoPeriodoModel.getRodado()));
  }

  public PermisoPeriodoModel entityToModel(PermisoPeriodo permisoPeriodo) {

    return new PermisoPeriodoModel(permisoPeriodo.getCantDias(), permisoPeriodo.isVacaciones(),
        rodadoConverter.entityToModel(permisoPeriodo.getRodado()));
  }
}
