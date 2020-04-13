package org.dfm.dam.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.dfm.dam.service.domain.DamServiceDomain;
import org.dfm.dam.service.domain.model.DamService;
import org.dfm.dam.service.domain.model.DamServiceInfo;
import org.dfm.dam.service.domain.port.ObtainDamService;
import org.dfm.dam.service.domain.port.RequestDamService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class AcceptanceTest {

  @Test
  @DisplayName("should be able to get damServices when asked for damServices from hard coded damServices")
  public void getDamServicesFromHardCoded() {
  /*
      RequestDamService    - left side port
      DamServiceDomain     - hexagon (domain)
      ObtainDamService     - right side port
   */
    RequestDamService requestDamService = new DamServiceDomain(); // the poem is hard coded
    DamServiceInfo damServiceInfo = requestDamService.getDamServices();
    assertThat(damServiceInfo).isNotNull();
    assertThat(damServiceInfo.getDamServices()).isNotEmpty().extracting("description")
        .contains("If you could read a leaf or tree\r\nyoud have no need of books.\r\n-- Alistair Cockburn (1987)");
  }

  @Test
  @DisplayName("should be able to get damServices when asked for damServices from stub")
  public void getDamServicesFromMockedStub(@Mock ObtainDamService obtainDamService) {
    // Stub
    DamService damService = DamService.builder().id(1L).description("I want to sleep\r\nSwat the flies\r\nSoftly, please.\r\n\r\n-- Masaoka Shiki (1867-1902)").build();
    Mockito.lenient().when(obtainDamService.getAllDamServices()).thenReturn(List.of(damService));
    // hexagon
    RequestDamService requestDamService = new DamServiceDomain(obtainDamService);
    DamServiceInfo damServiceInfo = requestDamService.getDamServices();
    assertThat(damServiceInfo).isNotNull();
    assertThat(damServiceInfo.getDamServices()).isNotEmpty().extracting("description")
        .contains("I want to sleep\r\nSwat the flies\r\nSoftly, please.\r\n\r\n-- Masaoka Shiki (1867-1902)");
  }
}
