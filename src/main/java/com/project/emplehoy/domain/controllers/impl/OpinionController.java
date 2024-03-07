package com.project.emplehoy.domain.controllers.impl;

import com.project.emplehoy.domain.controllers.interfaces.GenericController;
import com.project.emplehoy.domain.dto.OpinionDTO;
import com.project.emplehoy.domain.entities.OpinionEntity;
import com.project.emplehoy.domain.services.impl.OpinionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/opinions")
@AllArgsConstructor
public class OpinionController implements GenericController<OpinionDTO, OpinionEntity, Long> {

    private final OpinionService opinionService;

    @Override
    @PostMapping
    public OpinionDTO create(@RequestBody OpinionEntity entity) {
        return opinionService.create(entity);
    }

    @Override
    @PutMapping("/{id}")
    public OpinionDTO update(@PathVariable Long id, @RequestBody OpinionDTO entityDTO) {
        // Implementación del método si es necesario
        return null;
    }

    @Override
    @GetMapping
    public List<OpinionDTO> getAll() {
        return opinionService.getAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        opinionService.deleteById(id);
    }

    @Override
    @GetMapping("/{id}")
    public OpinionDTO getById(@PathVariable Long id) {
        return opinionService.getById(id);
    }
}
