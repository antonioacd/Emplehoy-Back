package com.project.emplehoy.domain.services.impl;

import com.project.emplehoy.domain.dto.LocationDTO;
import com.project.emplehoy.domain.entities.LocationEntity;
import com.project.emplehoy.domain.repositories.LocationRepository;
import com.project.emplehoy.domain.services.interfaces.GenericService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing location-related operations.
 */
@Service
@RequiredArgsConstructor
public class LocationService implements GenericService<LocationEntity, LocationDTO> {

    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;

    /**
     * Creates a new location and returns the location's information.
     *
     * @param location The location entity to be created.
     * @return A DTO (Data Transfer Object) containing the location's information.
     */
    @Override
    public LocationDTO create(LocationEntity location) {
        // Save the location entity and map it to a DTO
        return modelMapper.map(locationRepository.save(location), LocationDTO.class);
    }

    /**
     * Updates a location entity by ID and returns the updated location's information.
     *
     * @param id              The ID of the location to be updated.
     * @param updatedLocation The updated location entity.
     * @return A DTO (Data Transfer Object) containing the updated location's information.
     * @throws EntityNotFoundException If the location is not found.
     */
    @Override
    public LocationDTO update(Long id, LocationDTO updatedLocation) {
        // Find the existing location by ID or throw an exception if not found
        LocationEntity existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));

        // Update the location information
        existingLocation.setCountry(updatedLocation.getCountry());
        existingLocation.setRegion(updatedLocation.getRegion());
        existingLocation.setCity(updatedLocation.getCity());
        existingLocation.setStreet(updatedLocation.getStreet());

        // Save the updated location entity and map it to a DTO
        return modelMapper.map(locationRepository.save(existingLocation), LocationDTO.class);
    }

    /**
     * Deletes a location by its ID.
     *
     * @param id The ID of the location to be deleted.
     */
    @Override
    public void deleteById(Long id) {
        // Delete the location by ID
        locationRepository.deleteById(id);
    }

    /**
     * Retrieves location information by its ID.
     *
     * @param id The ID of the location to retrieve.
     * @return A DTO containing the location's information.
     * @throws EntityNotFoundException If the location is not found.
     */
    @Override
    public LocationDTO getById(Long id) {
        // Find the location by ID or throw an exception if not found
        LocationEntity locationEntity = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));
        // Map the location entity to a DTO
        return modelMapper.map(locationEntity, LocationDTO.class);
    }

    /**
     * Retrieves a list of all locations.
     *
     * @return A list of DTOs containing location information.
     */
    @Override
    public List<LocationDTO> getAll() {
        // Retrieve all locations from the repository
        List<LocationEntity> locations = locationRepository.findAll();
        // Map each location entity to a DTO and collect into a list
        return locations.stream()
                .map(location -> modelMapper.map(location, LocationDTO.class))
                .collect(Collectors.toList());
    }
}
