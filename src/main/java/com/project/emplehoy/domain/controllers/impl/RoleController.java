package com.project.emplehoy.domain.controllers.impl;


import com.project.emplehoy.domain.controllers.interfaces.GenericController;
import com.project.emplehoy.domain.dto.RoleDTO;
import com.project.emplehoy.domain.entities.RoleEntity;
import com.project.emplehoy.domain.services.impl.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController implements GenericController<RoleDTO, RoleEntity, Long> {

    private final RoleService roleService;

    @Override
    @PostMapping
    public RoleDTO create(@RequestBody RoleEntity entity) {
        return roleService.createRole(entity);
    }

    @Override
    @GetMapping("/{id}")
    public RoleDTO getById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @Override
    @GetMapping
    public List<RoleDTO> getAll() {
        return roleService.getAllRoles();
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        // Implementar si es necesario
    }

    @Override
    @PutMapping("/{id}")
    public RoleDTO update(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
        // Implementar si es necesario
        return null;
    }
}
