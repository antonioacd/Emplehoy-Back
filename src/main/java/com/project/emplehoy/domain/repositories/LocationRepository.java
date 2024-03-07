package com.project.emplehoy.domain.repositories;

import com.project.emplehoy.domain.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

}