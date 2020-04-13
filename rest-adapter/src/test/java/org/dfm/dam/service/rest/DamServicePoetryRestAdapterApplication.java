package org.dfm.dam.service.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.dfm.dam.service.domain.port.RequestDamService;

@SpringBootApplication
@ComponentScan(basePackages = "org.dfm.dam.service")
public class DamServicePoetryRestAdapterApplication {

  @MockBean
  private RequestDamService requestDamService;

  public static void main(String[] args) {
    SpringApplication.run(DamServicePoetryRestAdapterApplication.class, args);
  }
}
