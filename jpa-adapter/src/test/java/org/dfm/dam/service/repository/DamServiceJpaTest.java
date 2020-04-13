package org.dfm.dam.service.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.dfm.dam.service.domain.model.DamService;
import org.dfm.dam.service.domain.port.ObtainDamService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DamServiceJpaTest {

  @Autowired
  private ObtainDamService obtainDamService;

  @Test
  @DisplayName("should start the application")
  public void startup() {
    assertThat(Boolean.TRUE).isTrue();
  }

  @Sql(scripts = {"/sql/data.sql"})
  @Test
  @DisplayName("should give me damServices when asked for damServices from database")
  public void shouldGiveMeDamServicesWhenAskedForDamServices() {
    // Given from @Sql
    // When
    List<DamService> damServices = obtainDamService.getAllDamServices();
    // Then
    assertThat(damServices).isNotNull().extracting("description").contains("Twinkle twinkle little star");
  }
}
