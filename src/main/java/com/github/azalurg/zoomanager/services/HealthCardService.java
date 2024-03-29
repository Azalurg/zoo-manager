package com.github.azalurg.zoomanager.services;

import com.github.azalurg.zoomanager.api.ResourceNotFoundException;
import com.github.azalurg.zoomanager.models.HealthCard;
import com.github.azalurg.zoomanager.repositories.HealthCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HealthCardService {
    @Autowired
    private HealthCardRepository healthCardRepository;

    public List<HealthCard> findAll() {
        return (List<HealthCard>) healthCardRepository.findAll();
    }

    public HealthCard findById(Long id) {
        return healthCardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("HealthCard not found"));
    }

    public HealthCard createHealthCard(HealthCard healthCard) {
        return healthCardRepository.save(healthCard);
    }

    public void deleteHealthCard(Long id) {
        healthCardRepository.deleteById(id);
    }

    public HealthCard updateHealthCard(Long id, HealthCard newHealthCard) {
        HealthCard existingHealthCard = findById(id);

        existingHealthCard.setPesez(newHealthCard.getPesez());
        existingHealthCard.setDescription(newHealthCard.getDescription());
        existingHealthCard.setWeight(newHealthCard.getWeight());
        existingHealthCard.setHeight(newHealthCard.getHeight());
        existingHealthCard.setLength(newHealthCard.getLength());
        existingHealthCard.setGender(newHealthCard.getGender());
        existingHealthCard.setBornDate(newHealthCard.getBornDate());

        return healthCardRepository.save(existingHealthCard);
    }
}
