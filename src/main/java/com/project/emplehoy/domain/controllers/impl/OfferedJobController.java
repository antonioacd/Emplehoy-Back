package com.project.emplehoy.domain.controllers.impl;

import com.project.emplehoy.domain.controllers.interfaces.GenericController;
import com.project.emplehoy.domain.dto.OfferedJobDTO;
import com.project.emplehoy.domain.entities.OfferedJobEntity;
import com.project.emplehoy.domain.services.impl.OfferedJobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/offered-jobs")
@AllArgsConstructor
public class OfferedJobController implements GenericController<OfferedJobDTO, OfferedJobEntity, Long> {

    private final OfferedJobService offeredJobService;

    @Override
    @PostMapping
    public OfferedJobDTO create(@RequestBody OfferedJobEntity entity) {
        return offeredJobService.create(entity);
    }

    @Override
    @PutMapping("/{id}")
    public OfferedJobDTO update(@PathVariable Long id, @RequestBody OfferedJobDTO entity) {
        // Implementación del método si es necesario
        return null;
    }

    @Override
    @GetMapping
    public List<OfferedJobDTO> getAll() {
        return offeredJobService.getAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        offeredJobService.deleteById(id);
    }

    @Override
    @GetMapping("/{id}")
    public OfferedJobDTO getById(@PathVariable Long id) {
        return offeredJobService.getById(id);
    }
}
