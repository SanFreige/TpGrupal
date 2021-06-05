package com.unla.grupo12.converter;

import com.unla.grupo12.entity.PermisoDiario;
import com.unla.grupo12.model.PermisoDiarioModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("permisoDiarioConverter")
public class PermisoDiarioConverter {

  public List<PermisoDiarioModel> listPermisoDiarioModel(List<PermisoDiario> listPermisoDiario) {

    List<PermisoDiarioModel> listPermisoDiarioModel = new ArrayList<PermisoDiarioModel>();

    for (PermisoDiario p : listPermisoDiario) {
      PermisoDiarioModel permisoDiarioModel = new PermisoDiarioModel();
      permisoDiarioModel.setMotivo(p.getMotivo());
      listPermisoDiarioModel.add(permisoDiarioModel);
    }
    return listPermisoDiarioModel;
  }

  public List<PermisoDiario> listPermisoDiario(List<PermisoDiarioModel> listPermisoDiarioModel) {

    List<PermisoDiario> permisoDiarioList = new ArrayList<PermisoDiario>();

    for (PermisoDiarioModel p : listPermisoDiarioModel) {
      PermisoDiario permisoDiario = new PermisoDiario();
      permisoDiario.setMotivo(p.getMotivo());
      permisoDiarioList.add(permisoDiario);
    }
    return permisoDiarioList;
  }

  public PermisoDiario modelToEntity(PermisoDiarioModel permisoDiarioModel) {

    return new PermisoDiario(permisoDiarioModel.getMotivo());
  }

  public PermisoDiarioModel entityToModel(PermisoDiario permisoDiario) {

    return new PermisoDiarioModel(permisoDiario.getMotivo());
  }
}
