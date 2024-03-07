package com.project.emplehoy.domain.controllers.impl;

import com.project.emplehoy.domain.controllers.interfaces.GenericController;
import com.project.emplehoy.domain.dto.UserDTO;
import com.project.emplehoy.domain.entities.UserEntity;
import com.project.emplehoy.domain.services.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController implements GenericController<UserDTO, UserEntity, Long> {

    private final UserService userService;

    @Override
    @PostMapping
    public UserDTO create(@RequestBody UserEntity entity) {
        // Implementación del método si es necesario
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO entity) {
        // Implementación del método si es necesario
        return null;
    }

    @Override
    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @Override
    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
