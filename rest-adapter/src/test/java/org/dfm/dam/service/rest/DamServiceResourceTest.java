package org.dfm.dam.service.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.dfm.dam.service.domain.model.DamService;
import org.dfm.dam.service.domain.model.DamServiceInfo;
import org.dfm.dam.service.domain.port.RequestDamService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = DamServicePoetryRestAdapterApplication.class, webEnvironment = RANDOM_PORT)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class DamServiceResourceTest {

  private static final String LOCALHOST = "http://localhost:";
  private static final String API_URI = "/api/v1/damServices";
  @LocalServerPort
  private int port;
  @Autowired
  private TestRestTemplate restTemplate;
  @Autowired
  private RequestDamService requestDamService;

  @Test
  @DisplayName("should start the rest adapter application")
  public void startup() {
    assertThat(Boolean.TRUE).isTrue();
  }

  @Test
  @DisplayName("should give damServices when asked for damServices with the support of domain stub")
  public void obtainDamServicesFromDomainStub() {
    // Given
    DamService damService = DamService.builder().id(1L).description("Johnny Johnny Yes Papa !!").build();
    Mockito.lenient().when(requestDamService.getDamServices()).thenReturn(DamServiceInfo.builder().damServices(List.of(damService)).build());
    // When
    String url = LOCALHOST + port + API_URI;
    ResponseEntity<DamServiceInfo> responseEntity = restTemplate.getForEntity(url, DamServiceInfo.class);
    // Then
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody()).isNotNull();
    assertThat(responseEntity.getBody().getDamServices()).isNotEmpty().extracting("description")
        .contains("Johnny Johnny Yes Papa !!");
  }
}
