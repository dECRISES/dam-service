package org.dfm.dam.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.dfm.dam.service.domain.DamServiceDomain;
import org.dfm.dam.service.domain.port.ObtainDamService;
import org.dfm.dam.service.domain.port.RequestDamService;
import org.dfm.dam.service.repository.config.JpaAdapterConfig;

@SpringBootApplication
public class DamServiceE2EApplication {

  public static void main(String[] args) {
    SpringApplication.run(DamServiceE2EApplication.class);
  }

  @TestConfiguration
  @Import(JpaAdapterConfig.class)
  static class DamServiceConfig {

    @Bean
    public RequestDamService getRequestDamService(final ObtainDamService obtainDamService) {
      return new DamServiceDomain(obtainDamService);
    }
  }
}
