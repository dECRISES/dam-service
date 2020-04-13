package org.dfm.dam.service.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.dfm.dam.service")
public class DamServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DamServiceApplication.class, args);
  }
}
