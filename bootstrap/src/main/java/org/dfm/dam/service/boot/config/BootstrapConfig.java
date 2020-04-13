package org.dfm.dam.service.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.dfm.dam.service.domain.DamServiceDomain;
import org.dfm.dam.service.domain.port.ObtainDamService;
import org.dfm.dam.service.domain.port.RequestDamService;
import org.dfm.dam.service.repository.config.JpaAdapterConfig;

@Configuration
@Import(JpaAdapterConfig.class)
public class BootstrapConfig {

  @Bean
  public RequestDamService getRequestDamService(ObtainDamService obtainDamService) {
    return new DamServiceDomain(obtainDamService);
  }
}
