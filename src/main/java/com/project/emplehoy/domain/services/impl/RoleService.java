package com.project.emplehoy.domain.services.impl;

import com.project.emplehoy.domain.dto.RoleDTO;
import com.project.emplehoy.domain.entities.RoleEntity;
import com.project.emplehoy.domain.repositories.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing roles-related operations.
 */
@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Creates a new role and returns the role's information.
     *
     * @param role The role entity to be created.
     * @return A DTO (Data Transfer Object) containing the role's information.
     */
    @Secured({"ROLE_ADMIN"})
    public RoleDTO createRole(RoleEntity role) {
        return modelMapper.map(roleRepository.save(role), RoleDTO.class);
    }

    /**
     * Retrieves role information by its ID.
     *
     * @param id The ID of the role to retrieve.
     * @return A DTO containing the role's information.
     * @throws EntityNotFoundException If the role is not found.
     */
    @Secured({"ROLE_ADMIN"})
    public RoleDTO getRoleById(Long id) {
        RoleEntity roleEntity = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        return modelMapper.map(roleEntity, RoleDTO.class);
    }

    /**
     * Retrieves a list of all roles.
     *
     * @return A list of DTOs containing role information.
     */
    @Secured({"ROLE_ADMIN"})
    public List<RoleDTO> getAllRoles() {
        List<RoleEntity> roles = roleRepository.findAll();

        return roles.stream()
                .map(rol -> modelMapper.map(rol, RoleDTO.class))
                .collect(Collectors.toList());
    }
}
