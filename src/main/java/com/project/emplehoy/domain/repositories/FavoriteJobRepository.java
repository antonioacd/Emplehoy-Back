package com.project.emplehoy.domain.repositories;

import com.project.emplehoy.domain.entities.FavoriteJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteJobRepository extends JpaRepository<FavoriteJobEntity, Long> {

}