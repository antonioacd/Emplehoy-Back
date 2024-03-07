package com.project.emplehoy.domain.services.impl;

import com.project.emplehoy.domain.dto.OpinionDTO;
import com.project.emplehoy.domain.entities.OpinionEntity;
import com.project.emplehoy.domain.repositories.OpinionRepository;
import com.project.emplehoy.domain.repositories.UserRepository;
import com.project.emplehoy.domain.services.interfaces.GenericService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing opinion-related operations.
 */
@Service
@RequiredArgsConstructor
public class OpinionService implements GenericService<OpinionEntity, OpinionDTO> {

    private final OpinionRepository opinionRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    /**
     * Creates a new opinion and returns the opinion's information.
     *
     * @param opinion The opinion entity to be created.
     * @return A DTO (Data Transfer Object) containing the opinion's information.
     */
    @Override
    public OpinionDTO create(OpinionEntity opinion) {
        opinion.setUser(userRepository.getReferenceById(opinion.getUser().getId()));
        OpinionEntity savedOpinion = opinionRepository.save(opinion);
        return modelMapper.map(savedOpinion, OpinionDTO.class);
    }

    /**
     * Updates an existing opinion and returns the updated opinion's information.
     *
     * @param id             The ID of the opinion to be updated.
     * @param updatedOpinion The updated opinion entity.
     * @return A DTO (Data Transfer Object) containing the updated opinion's information.
     * @throws EntityNotFoundException If the opinion is not found.
     */
    @Override
    public OpinionDTO update(Long id, OpinionDTO updatedOpinion) {
        OpinionEntity existingOpinion = opinionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Opinion not found"));

        existingOpinion.setText(updatedOpinion.getText());
        existingOpinion.setRating(updatedOpinion.getRating());

        if (!existingOpinion.getUser().getId().equals(updatedOpinion.getUser().getId())) {
            existingOpinion.setUser(userRepository.getReferenceById(updatedOpinion.getUser().getId()));
        }

        return modelMapper.map(opinionRepository.save(existingOpinion), OpinionDTO.class);
    }

    /**
     * Deletes a opinion by its ID.
     *
     * @param id The ID of the opinion to be deleted.
     */
    @Override
    public void deleteById(Long id) {
        opinionRepository.deleteById(id);
    }

    /**
     * Retrieves opinion information by its ID.
     *
     * @param id The ID of the opinion to retrieve.
     * @return A DTO containing the opinion's information.
     * @throws EntityNotFoundException If the opinion is not found.
     */
    @Override
    public OpinionDTO getById(Long id) {
        OpinionEntity opinionEntity = opinionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Opinion not found"));
        return modelMapper.map(opinionEntity, OpinionDTO.class);
    }

    /**
     * Retrieves a list of all opinions.
     *
     * @return A list of DTOs containing opinion information.
     */
    @Override
    public List<OpinionDTO> getAll() {
        List<OpinionEntity> opinions = opinionRepository.findAll();
        return opinions.stream()
                .map(opinion -> modelMapper.map(opinion, OpinionDTO.class))
                .collect(Collectors.toList());
    }
}
