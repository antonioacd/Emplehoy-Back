package com.project.emplehoy.domain.services.impl;


import com.project.emplehoy.domain.dto.RoleDTO;
import com.project.emplehoy.domain.dto.UserDTO;
import com.project.emplehoy.domain.entities.UserEntity;
import com.project.emplehoy.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing user-related operations.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    /**
     * Deletes a user by their user ID.
     *
     * @param id The ID of the user to be deleted.
     */
    @Secured({"ROLE_ADMIN"})
    public void deleteUserById(Long id) {
        // Delete the user by ID
        userRepository.deleteById(id);
    }

    /**
     * Retrieves user information by their user ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return A DTO containing the user's information.
     * @throws EntityNotFoundException If the user is not found.
     */
    @Secured({"ROLE_ADMIN"})
    public UserDTO getUserById(Long userId) {
        // Find the user by ID or throw an exception if not found
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Map the user entity to a DTO
        return modelMapper.map(user, UserDTO.class);
    }

    /**
     * Retrieves user information by their user ID.
     *
     * @param email The email of the user to retrieve.
     * @return A DTO containing the user's information.
     * @throws EntityNotFoundException If the user is not found.
     */
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public UserDTO getUserByEmail(String email) {
        // Find the user by email or throw an exception if not found
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Map the user entity to a DTO
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        // Map roles to DTOs and set them in the UserDTO
        userDTO.setRoles(user.getRoles().stream()
                .map(rol -> modelMapper.map(rol, RoleDTO.class))
                .collect(Collectors.toList()));

        return userDTO;
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A list of DTOs containing user information.
     */
    @Secured({"ROLE_ADMIN"})
    public List<UserDTO> getAllUsers() {
        // Retrieve all users from the repository
        List<UserEntity> users = userRepository.findAll();

        // Map each user entity to a DTO and collect into a list
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of users by schedule id.
     *
     * @param scheduleId
     * @return A list of DTOs containing user information.

     @Secured({"ROLE_ADMIN"}) public List<UserEntity> getUsersByScheduleId(Long scheduleId) {
     return userRepository.findUsersByScheduleId(scheduleId);
     }*/
}
