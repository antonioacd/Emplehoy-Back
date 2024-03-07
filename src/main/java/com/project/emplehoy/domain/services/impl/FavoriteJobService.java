package com.project.emplehoy.domain.services.impl;

import com.project.emplehoy.domain.dto.FavoriteJobDTO;
import com.project.emplehoy.domain.entities.FavoriteJobEntity;
import com.project.emplehoy.domain.repositories.FavoriteJobRepository;
import com.project.emplehoy.domain.repositories.JobRepository;
import com.project.emplehoy.domain.repositories.UserRepository;
import com.project.emplehoy.domain.services.interfaces.GenericService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing favorite job-related operations.
 */
@Service
@RequiredArgsConstructor
public class FavoriteJobService implements GenericService<FavoriteJobEntity, FavoriteJobDTO> {

    private final FavoriteJobRepository favoriteJobRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    /**
     * Creates a new favorite job and returns its information.
     *
     * @param favoriteJob The favorite job entity to be created.
     * @return A DTO (Data Transfer Object) containing the favorite job's information.
     */
    @Override
    public FavoriteJobDTO create(FavoriteJobEntity favoriteJob) {
        return modelMapper.map(favoriteJobRepository.save(favoriteJob), FavoriteJobDTO.class);
    }

    /**
     * Updates an existing favorite job entity by ID and returns the updated job's information.
     *
     * @param id         The ID of the favorite job to be updated.
     * @param updatedJob The updated favorite job entity.
     * @return A DTO (Data Transfer Object) containing the updated favorite job's information.
     * @throws EntityNotFoundException If the favorite job is not found.
     */
    @Override
    public FavoriteJobDTO update(Long id, FavoriteJobDTO updatedJob) {
        FavoriteJobEntity existingFavoriteJob = favoriteJobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Favorite job not found"));

        if (!existingFavoriteJob.getUser().getId().equals(updatedJob.getUser().getId())) {
            existingFavoriteJob.setUser(userRepository.getReferenceById(updatedJob.getUser().getId()));
        }

        if (!existingFavoriteJob.getUser().getId().equals(updatedJob.getUser().getId())) {
            existingFavoriteJob.setJob(jobRepository.getReferenceById(updatedJob.getJob().getId()));
        }

        return modelMapper.map(favoriteJobRepository.save(existingFavoriteJob), FavoriteJobDTO.class);
    }

    /**
     * Deletes a favorite job by its ID.
     *
     * @param id The ID of the favorite job to be deleted.
     */
    @Override
    public void deleteById(Long id) {
        favoriteJobRepository.deleteById(id);
    }

    /**
     * Retrieves favorite job information by its ID.
     *
     * @param id The ID of the favorite job to retrieve.
     * @return A DTO containing the favorite job's information.
     * @throws EntityNotFoundException If the favorite job is not found.
     */
    @Override
    public FavoriteJobDTO getById(Long id) throws EntityNotFoundException {
        FavoriteJobEntity favoriteJobEntity = favoriteJobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Favorite job not found"));
        return modelMapper.map(favoriteJobEntity, FavoriteJobDTO.class);
    }

    /**
     * Retrieves a list of all favorite jobs.
     *
     * @return A list of DTOs containing favorite job information.
     */
    @Override
    public List<FavoriteJobDTO> getAll() {
        List<FavoriteJobEntity> favoriteJobs = favoriteJobRepository.findAll();
        return favoriteJobs.stream()
                .map(favoriteJob -> modelMapper.map(favoriteJob, FavoriteJobDTO.class))
                .collect(Collectors.toList());
    }
}
