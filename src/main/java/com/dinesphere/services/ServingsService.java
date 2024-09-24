package com.dinesphere.services;

import com.dinesphere.dtos.ServingsDTO;
import com.dinesphere.entities.Servings;
import com.dinesphere.mappers.ServingsMapper;
import com.dinesphere.repositories.ServingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServingsService {
    @Autowired
    private ServingsRepository servingRepository;

    public ServingsDTO createServing(ServingsDTO servingDTO) {
        Servings serving = ServingsMapper.toEntity(servingDTO);
        Servings savedServing = servingRepository.save(serving);
        return ServingsMapper.toDTO(savedServing);
    }

    public Optional<ServingsDTO> getServing(Long id) {
        return servingRepository.findById(id).map(ServingsMapper::toDTO);
    }

    public void deleteServing(Long id) {
        servingRepository.deleteById(id);
    }

}
