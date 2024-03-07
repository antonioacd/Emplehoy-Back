package com.project.emplehoy.domain.repositories;

import com.project.emplehoy.domain.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Long> {

}