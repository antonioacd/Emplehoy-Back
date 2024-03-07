package com.project.emplehoy.domain.controllers.impl;

import com.project.emplehoy.domain.controllers.interfaces.GenericController;
import com.project.emplehoy.domain.dto.JobDTO;
import com.project.emplehoy.domain.entities.JobEntity;
import com.project.emplehoy.domain.services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/jobs")
@AllArgsConstructor
public class JobController implements GenericController<JobDTO, JobEntity, Long> {

    private final JobService jobService;

    @Override
    @PostMapping
    public JobDTO create(@RequestBody JobEntity entity) {
        return jobService.create(entity);
    }

    @Override
    @PutMapping("/{id}")
    public JobDTO update(@PathVariable Long id, @RequestBody JobDTO jonDTO) {
        return jobService.update(id, jonDTO);
    }

    @Override
    @GetMapping
    public List<JobDTO> getAll() {
        return jobService.getAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        jobService.deleteById(id);
    }

    @Override
    @GetMapping("/{id}")
    public JobDTO getById(@PathVariable Long id) {
        return jobService.getById(id);
    }
}
