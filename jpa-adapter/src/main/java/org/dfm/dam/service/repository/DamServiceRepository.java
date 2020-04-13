package org.dfm.dam.service.repository;

import java.util.List;
import java.util.stream.Collectors;
import org.dfm.dam.service.domain.model.DamService;
import org.dfm.dam.service.domain.port.ObtainDamService;
import org.dfm.dam.service.repository.dao.DamServiceDao;
import org.dfm.dam.service.repository.entity.DamServiceEntity;

public class DamServiceRepository implements ObtainDamService {

  private DamServiceDao damServiceDao;

  public DamServiceRepository(DamServiceDao damServiceDao) {
    this.damServiceDao = damServiceDao;
  }

  @Override
  public List<DamService> getAllDamServices() {
    return damServiceDao.findAll().stream().map(DamServiceEntity::toModel).collect(Collectors.toList());
  }
}
