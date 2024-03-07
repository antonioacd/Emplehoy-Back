package com.project.emplehoy.domain.repositories;

import com.project.emplehoy.domain.entities.OfferedJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferedJobRepository extends JpaRepository<OfferedJobEntity, Long> {

}