package com.project.emplehoy.domain.controllers.interfaces;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface GenericController<DTO, ENTITY, ID> {

    @PostMapping
    DTO create(@RequestBody ENTITY entity);

    @PutMapping("/{id}")
    DTO update(@PathVariable ID id, @RequestBody DTO entityDTO);

    @GetMapping
    List<DTO> getAll();

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable ID id);

    @GetMapping("/{id}")
    DTO getById(@PathVariable ID id);
}
