package com.project.emplehoy.domain.services.impl;

import com.project.emplehoy.domain.dto.CompletedJobDTO;
import com.project.emplehoy.domain.entities.CompletedJobEntity;
import com.project.emplehoy.domain.repositories.CompletedJobRepository;
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
 * Service class for managing completed job-related operations.
 */
@Service
@RequiredArgsConstructor
public class CompletedJobService implements GenericService<CompletedJobEntity, CompletedJobDTO> {

    private final CompletedJobRepository completedJobRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    /**
     * Creates a new completed job and returns its information.
     *
     * @param completedJob The completed job entity to be created.
     * @return A DTO (Data Transfer Object) containing the completed job's information.
     */
    @Override
    public CompletedJobDTO create(CompletedJobEntity completedJob) {
        return modelMapper.map(completedJobRepository.save(completedJob), CompletedJobDTO.class);
    }

    /**
     * Updates an existing completed job entity by ID and returns the updated job's information.
     *
     * @param id         The ID of the completed job to be updated.
     * @param updatedJob The updated completed job entity.
     * @return A DTO (Data Transfer Object) containing the updated completed job's information.
     * @throws EntityNotFoundException If the completed job is not found.
     */
    @Override
    public CompletedJobDTO update(Long id, CompletedJobDTO updatedJob) {
        CompletedJobEntity existingCompletedJob = completedJobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Completed job not found"));

        if (!existingCompletedJob.getUser().getId().equals(updatedJob.getUser().getId())) {
            existingCompletedJob.setUser(userRepository.getReferenceById(updatedJob.getUser().getId()));
        }

        if (!existingCompletedJob.getUser().getId().equals(updatedJob.getUser().getId())) {
            existingCompletedJob.setJob(jobRepository.getReferenceById(updatedJob.getJob().getId()));
        }

        return modelMapper.map(completedJobRepository.save(existingCompletedJob), CompletedJobDTO.class);
    }

    /**
     * Deletes a completed job by its ID.
     *
     * @param id The ID of the completed job to be deleted.
     */
    @Override
    public void deleteById(Long id) {
        completedJobRepository.deleteById(id);
    }

    /**
     * Retrieves completed job information by its ID.
     *
     * @param id The ID of the completed job to retrieve.
     * @return A DTO containing the completed job's information.
     * @throws EntityNotFoundException If the completed job is not found.
     */
    @Override
    public CompletedJobDTO getById(Long id) throws EntityNotFoundException {
        CompletedJobEntity completedJobEntity = completedJobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Completed job not found"));
        return modelMapper.map(completedJobEntity, CompletedJobDTO.class);
    }

    /**
     * Retrieves a list of all completed jobs.
     *
     * @return A list of DTOs containing completed job information.
     */
    @Override
    public List<CompletedJobDTO> getAll() {
        List<CompletedJobEntity> completedJobs = completedJobRepository.findAll();
        return completedJobs.stream()
                .map(completedJob -> modelMapper.map(completedJob, CompletedJobDTO.class))
                .collect(Collectors.toList());
    }
}
