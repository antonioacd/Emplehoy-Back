package com.project.emplehoy.domain.repositories;

import com.project.emplehoy.domain.entities.CompletedJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedJobRepository extends JpaRepository<CompletedJobEntity, Long> {

}