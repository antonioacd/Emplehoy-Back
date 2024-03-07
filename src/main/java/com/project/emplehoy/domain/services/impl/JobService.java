package com.project.emplehoy.domain.services;

import com.project.emplehoy.domain.dto.JobDTO;
import com.project.emplehoy.domain.entities.JobEntity;
import com.project.emplehoy.domain.repositories.JobRepository;
import com.project.emplehoy.domain.repositories.LocationRepository;
import com.project.emplehoy.domain.services.interfaces.GenericService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing job-related operations.
 */
@Service
@RequiredArgsConstructor
public class JobService implements GenericService<JobEntity, JobDTO> {

    private final JobRepository jobRepository;
    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;

    /**
     * Creates a new job and returns the job's information.
     *
     * @param job The job entity to be created.
     * @return A DTO (Data Transfer Object) containing the job's information.
     */
    @Override
    public JobDTO create(JobEntity job) {
        return modelMapper.map(jobRepository.save(job), JobDTO.class);
    }

    /**
     * Updates an existing job entity by ID and returns the updated job's information.
     *
     * @param id         The ID of the job to be updated.
     * @param updatedJob The updated job entity.
     * @return A DTO (Data Transfer Object) containing the updated job's information.
     * @throws EntityNotFoundException If the job is not found.
     */
    @Override
    public JobDTO update(Long id, JobDTO updatedJob) {
        JobEntity existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Job not found"));

        existingJob.setName(updatedJob.getName());
        existingJob.setStartDate(updatedJob.getStartDate());
        existingJob.setEndDate(updatedJob.getEndDate());
        existingJob.setScheduleDescription(updatedJob.getScheduleDescription());
        existingJob.setJobDescription(updatedJob.getJobDescription());
        existingJob.setImage(updatedJob.getImage());

        if (!existingJob.getLocation().getId().equals(updatedJob.getLocation().getId())) {
            existingJob.setLocation(locationRepository.getReferenceById(updatedJob.getLocation().getId()));
        }

        return modelMapper.map(jobRepository.save(existingJob), JobDTO.class);
    }

    /**
     * Deletes a job by its ID.
     *
     * @param id The ID of the job to be deleted.
     */
    @Override
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }

    /**
     * Retrieves job information by its ID.
     *
     * @param id The ID of the job to retrieve.
     * @return A DTO containing the job's information.
     * @throws EntityNotFoundException If the job is not found.
     */
    @Override
    public JobDTO getById(Long id) throws EntityNotFoundException {
        JobEntity jobEntity = jobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Job not found"));
        return modelMapper.map(jobEntity, JobDTO.class);
    }

    /**
     * Retrieves a list of all jobs.
     *
     * @return A list of DTOs containing job information.
     */
    @Override
    public List<JobDTO> getAll() {
        List<JobEntity> jobs = jobRepository.findAll();
        return jobs.stream()
                .map(job -> modelMapper.map(job, JobDTO.class))
                .collect(Collectors.toList());
    }
}
