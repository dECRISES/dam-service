package org.dfm.dam.service.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.dfm.dam.service.domain.model.DamServiceInfo;
import org.dfm.dam.service.domain.port.RequestDamService;

@RestController
@RequestMapping("/api/v1/damServices")
public class DamServiceResource {

  private RequestDamService requestDamService;

  public DamServiceResource(RequestDamService requestDamService) {
    this.requestDamService = requestDamService;
  }

  @GetMapping
  public ResponseEntity<DamServiceInfo> getDamServices() {
    return ResponseEntity.ok(requestDamService.getDamServices());
  }
}
