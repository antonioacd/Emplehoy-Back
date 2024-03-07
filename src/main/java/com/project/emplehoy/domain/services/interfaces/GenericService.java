package com.project.emplehoy.domain.services.interfaces;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface GenericService<Entity, DTO> {

    DTO create(Entity entity);

    DTO update(Long id, DTO updatedEntity);

    void deleteById(Long id);

    DTO getById(Long id) throws EntityNotFoundException;

    List<DTO> getAll();
}
