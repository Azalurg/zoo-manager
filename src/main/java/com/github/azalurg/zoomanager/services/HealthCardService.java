package com.github.azalurg.zoomanager.services;

import com.github.azalurg.zoomanager.api.ResourceNotFoundException;
import com.github.azalurg.zoomanager.models.HealthCard;
import com.github.azalurg.zoomanager.repositories.HealthCardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HealthCardService {
    private final HealthCardRepository healthCardRepository;

    public HealthCardService(HealthCardRepository healthCardRepository) {
        this.healthCardRepository = healthCardRepository;
    }

    public List<HealthCard> getAllHealthCards() {
        return (List<HealthCard>) healthCardRepository.findAll();
    }

    public HealthCard getHealthCardById(Long id) {
        return healthCardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("HealthCard not found"));
    }

    public HealthCard createHealthCard(HealthCard healthCard) {
        return healthCardRepository.save(healthCard);
    }

    public void deleteHealthCard(Long id) {
        healthCardRepository.deleteById(id);
    }

}
