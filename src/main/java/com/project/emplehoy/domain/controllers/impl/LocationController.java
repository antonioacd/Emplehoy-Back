package com.project.emplehoy.domain.controllers.impl;

import com.project.emplehoy.domain.controllers.interfaces.GenericController;
import com.project.emplehoy.domain.dto.LocationDTO;
import com.project.emplehoy.domain.entities.LocationEntity;
import com.project.emplehoy.domain.services.impl.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/locations")
@AllArgsConstructor
public class LocationController implements GenericController<LocationDTO, LocationEntity, Long> {

    private final LocationService locationService;

    @Override
    @PostMapping
    public LocationDTO create(@RequestBody LocationEntity entity) {
        return locationService.create(entity);
    }

    @Override
    @PutMapping("/{id}")
    public LocationDTO update(@PathVariable Long id, @RequestBody LocationDTO locationDTO) {
        return locationService.update(id, locationDTO);
    }

    @Override
    @GetMapping
    public List<LocationDTO> getAll() {
        return locationService.getAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        locationService.deleteById(id);
    }

    @Override
    @GetMapping("/{id}")
    public LocationDTO getById(@PathVariable Long id) {
        return locationService.getById(id);
    }
}
