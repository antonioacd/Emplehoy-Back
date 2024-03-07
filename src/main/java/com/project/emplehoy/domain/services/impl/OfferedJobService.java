package com.project.emplehoy.domain.services.impl;

import com.project.emplehoy.domain.dto.OfferedJobDTO;
import com.project.emplehoy.domain.entities.OfferedJobEntity;
import com.project.emplehoy.domain.repositories.JobRepository;
import com.project.emplehoy.domain.repositories.OfferedJobRepository;
import com.project.emplehoy.domain.repositories.UserRepository;
import com.project.emplehoy.domain.services.interfaces.GenericService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing offered job-related operations.
 */
@Service
@RequiredArgsConstructor
public class OfferedJobService implements GenericService<OfferedJobEntity, OfferedJobDTO> {

    private final OfferedJobRepository offeredJobRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    /**
     * Creates a new offered job and returns its information.
     *
     * @param offeredJob The offered job entity to be created.
     * @return A DTO (Data Transfer Object) containing the offered job's information.
     */
    @Override
    public OfferedJobDTO create(OfferedJobEntity offeredJob) {
        return modelMapper.map(offeredJobRepository.save(offeredJob), OfferedJobDTO.class);
    }

    /**
     * Updates an existing offered job entity by ID and returns the updated job's information.
     *
     * @param id         The ID of the offered job to be updated.
     * @param updatedJob The updated offered job entity.
     * @return A DTO (Data Transfer Object) containing the updated offered job's information.
     * @throws EntityNotFoundException If the offered job is not found.
     */
    @Override
    public OfferedJobDTO update(Long id, OfferedJobDTO updatedJob) {
        OfferedJobEntity existingOfferedJob = offeredJobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Offered job not found"));

        if (!existingOfferedJob.getUser().getId().equals(updatedJob.getUser().getId())) {
            existingOfferedJob.setUser(userRepository.getReferenceById(updatedJob.getUser().getId()));
        }

        if (!existingOfferedJob.getUser().getId().equals(updatedJob.getUser().getId())) {
            existingOfferedJob.setJob(jobRepository.getReferenceById(updatedJob.getJob().getId()));
        }

        return modelMapper.map(offeredJobRepository.save(existingOfferedJob), OfferedJobDTO.class);
    }

    /**
     * Deletes a offered job by its ID.
     *
     * @param id The ID of the offered job to be deleted.
     */
    @Override
    public void deleteById(Long id) {
        offeredJobRepository.deleteById(id);
    }

    /**
     * Retrieves offered job information by its ID.
     *
     * @param id The ID of the offered job to retrieve.
     * @return A DTO containing the offered job's information.
     * @throws EntityNotFoundException If the offered job is not found.
     */
    @Override
    public OfferedJobDTO getById(Long id) throws EntityNotFoundException {
        OfferedJobEntity offeredJobEntity = offeredJobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Offered job not found"));
        return modelMapper.map(offeredJobEntity, OfferedJobDTO.class);
    }

    /**
     * Retrieves a list of all offered jobs.
     *
     * @return A list of DTOs containing offered job information.
     */
    @Override
    public List<OfferedJobDTO> getAll() {
        List<OfferedJobEntity> offeredJobs = offeredJobRepository.findAll();
        return offeredJobs.stream()
                .map(offeredJob -> modelMapper.map(offeredJob, OfferedJobDTO.class))
                .collect(Collectors.toList());
    }
}
