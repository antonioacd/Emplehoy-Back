package com.project.emplehoy.domain.controllers.impl;

import com.project.emplehoy.domain.controllers.interfaces.GenericController;
import com.project.emplehoy.domain.dto.FavoriteJobDTO;
import com.project.emplehoy.domain.entities.FavoriteJobEntity;
import com.project.emplehoy.domain.services.impl.FavoriteJobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/favorite-jobs")
@AllArgsConstructor
public class FavoriteJobController implements GenericController<FavoriteJobDTO, FavoriteJobEntity, Long> {

    private final FavoriteJobService favoriteJobService;

    @Override
    @PostMapping
    public FavoriteJobDTO create(@RequestBody FavoriteJobEntity entity) {
        return favoriteJobService.create(entity);
    }

    @Override
    @PutMapping("/{id}")
    public FavoriteJobDTO update(@PathVariable Long id, @RequestBody FavoriteJobDTO entity) {
        // Implementación del método si es necesario
        return null;
    }

    @Override
    @GetMapping
    public List<FavoriteJobDTO> getAll() {
        return favoriteJobService.getAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        favoriteJobService.deleteById(id);
    }

    @Override
    @GetMapping("/{id}")
    public FavoriteJobDTO getById(@PathVariable Long id) {
        return favoriteJobService.getById(id);
    }
}
