package com.project.emplehoy.domain.repositories;

import com.project.emplehoy.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

    /*@Query("SELECT DISTINCT u FROM UserEntity u " +
            "JOIN TicketEntity t ON u.id = t.user.id " +
            "JOIN ScheduleEntity s ON t.schedule.id = s.id " +
            "WHERE s.id = :scheduleId")
    List<UserEntity> findUsersByScheduleId(@Param("scheduleId") Long scheduleId);*/
}