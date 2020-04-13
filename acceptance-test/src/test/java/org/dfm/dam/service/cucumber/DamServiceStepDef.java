package org.dfm.dam.service.cucumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.cucumber.java8.HookNoArgsBody;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.dfm.dam.service.DamServiceE2EApplication;
import org.dfm.dam.service.domain.model.DamService;
import org.dfm.dam.service.domain.model.DamServiceInfo;
import org.dfm.dam.service.repository.dao.DamServiceDao;
import org.dfm.dam.service.repository.entity.DamServiceEntity;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DamServiceE2EApplication.class, webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = DamServiceE2EApplication.class, loader = SpringBootContextLoader.class)
public class DamServiceStepDef implements En {

  private static final String LOCALHOST = "http://localhost:";
  private static final String API_URI = "/api/v1/damServices";
  @LocalServerPort
  private int port;
  private ResponseEntity<DamServiceInfo> responseEntity;

  public DamServiceStepDef(TestRestTemplate restTemplate, DamServiceDao poetryDao) {

    DataTableType((Map<String, String> row) -> DamService.builder().description(row.get("description")).build());
    DataTableType((Map<String, String> row) -> DamServiceEntity.builder().description(row.get("description")).build());

    Before((HookNoArgsBody) poetryDao::deleteAll);
    After((HookNoArgsBody) poetryDao::deleteAll);

    Given("the following damServices exists in the library", (DataTable dataTable) -> {
      List<DamServiceEntity> poems = dataTable.asList(DamServiceEntity.class);
      poetryDao.saveAll(poems);
    });

    When("user requests for all damServices", () -> {
      String url = LOCALHOST + port + API_URI;
      responseEntity = restTemplate.getForEntity(url, DamServiceInfo.class);
    });

    Then("the user gets the following damServices", (DataTable dataTable) -> {
      List<DamService> expectedDamServiceInfo = dataTable.asList(DamService.class);
      assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(responseEntity.getBody()).isNotNull();
      assertThat(responseEntity.getBody().getDamServices()).isNotEmpty().extracting("description")
          .contains(expectedDamServiceInfo.stream().map(DamService::getDescription).toArray());
    });
  }
}


