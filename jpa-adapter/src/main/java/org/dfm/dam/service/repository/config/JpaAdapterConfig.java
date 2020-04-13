package org.dfm.dam.service.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.dfm.dam.service.domain.port.ObtainDamService;
import org.dfm.dam.service.repository.DamServiceRepository;
import org.dfm.dam.service.repository.dao.DamServiceDao;

@Configuration
@EntityScan("org.dfm.dam.service.repository.entity")
@EnableJpaRepositories("org.dfm.dam.service.repository.dao")
public class JpaAdapterConfig {

  @Bean
  public ObtainDamService getDamServiceRepository(DamServiceDao damServiceDao) {
    return new DamServiceRepository(damServiceDao);
  }
}
