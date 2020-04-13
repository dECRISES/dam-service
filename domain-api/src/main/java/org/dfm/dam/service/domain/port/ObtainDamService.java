package org.dfm.dam.service.domain.port;

import java.util.List;
import org.dfm.dam.service.domain.model.DamService;

public interface ObtainDamService {

  default List<DamService> getAllDamServices() {
    DamService damService = DamService.builder().id(1L).description("If you could read a leaf or tree\r\nyoud have no need of books.\r\n-- Alistair Cockburn (1987)").build();
    return List.of(damService);
  }
}
