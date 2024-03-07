package com.project.emplehoy.domain.controllers.impl;

import com.project.emplehoy.domain.controllers.interfaces.GenericController;
import com.project.emplehoy.domain.dto.CompletedJobDTO;
import com.project.emplehoy.domain.entities.CompletedJobEntity;
import com.project.emplehoy.domain.services.impl.CompletedJobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/completed-jobs")
@AllArgsConstructor
public class CompletedJobController implements GenericController<CompletedJobDTO, CompletedJobEntity, Long> {

    private final CompletedJobService completedJobService;

    @Override
    @PostMapping
    public CompletedJobDTO create(@RequestBody CompletedJobEntity entity) {
        return completedJobService.create(entity);
    }

    @Override
    @PutMapping("/{id}")
    public CompletedJobDTO update(@PathVariable Long id, @RequestBody CompletedJobDTO entity) {
        // Implementación del método si es necesario
        return null;
    }

    @Override
    @GetMapping
    public List<CompletedJobDTO> getAll() {
        return completedJobService.getAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        completedJobService.deleteById(id);
    }

    @Override
    @GetMapping("/{id}")
    public CompletedJobDTO getById(@PathVariable Long id) {
        return completedJobService.getById(id);
    }
}
