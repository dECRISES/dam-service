package org.dfm.dam.service.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.dfm.dam.service.domain.port.ObtainDamService;
import org.dfm.dam.service.repository.dao.DamServiceDao;

@SpringBootApplication
public class DamServiceJpaAdapterApplication {

  public static void main(String[] args) {
    SpringApplication.run(DamServiceJpaAdapterApplication.class, args);
  }

  @TestConfiguration
  static class DamServiceJpaTestConfig {

    @Bean
    public ObtainDamService getObtainDamServiceRepository(DamServiceDao damServiceDao) {
      return new DamServiceRepository(damServiceDao);
    }
  }
}
