package org.dfm.dam.service.repository.entity;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dfm.dam.service.domain.model.DamService;

@Table(name = "T_DAM_SERVICE")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DamServiceEntity {

  @Id
  @GeneratedValue(strategy = AUTO)
  private Long id;

  @Column(name = "DESCRIPTION")
  private String description;

  public DamService toModel() {
    return DamService.builder().id(id).description(description).build();
  }
}
