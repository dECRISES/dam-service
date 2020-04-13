package org.dfm.dam.service.domain;

import org.dfm.dam.service.domain.model.DamServiceInfo;
import org.dfm.dam.service.domain.port.ObtainDamService;
import org.dfm.dam.service.domain.port.RequestDamService;

public class DamServiceDomain implements RequestDamService {

  private ObtainDamService obtainDamService;

  public DamServiceDomain() {
    this(new ObtainDamService() {
    });
  }

  public DamServiceDomain(ObtainDamService obtainDamService) {
    this.obtainDamService = obtainDamService;
  }

  @Override
  public DamServiceInfo getDamServices() {
    return DamServiceInfo.builder().damServices(obtainDamService.getAllDamServices()).build();
  }
}
