package org.dfm.dam.service.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.dfm.dam.service.repository.entity.DamServiceEntity;

@Repository
public interface DamServiceDao extends JpaRepository<DamServiceEntity, Long> {

}
