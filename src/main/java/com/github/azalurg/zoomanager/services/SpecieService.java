package com.github.azalurg.zoomanager.services;

import com.github.azalurg.zoomanager.models.Specie;
import com.github.azalurg.zoomanager.repositories.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SpecieService {
    @Autowired
    private SpecieRepository specieRepository;

    public List<Specie> findAll() {
        return specieRepository.findAll();
    }

    public Specie findById(Long id) {
        return specieRepository.findById(id).orElse(null);
    }

    public Specie createSpecie(Specie specie) {
        return specieRepository.save(specie);
    }

    public Specie updateSpecie(Long id, Specie newSpecie) {
        Specie existingSpecie = findById(id);

        existingSpecie.setName(newSpecie.getName());
        existingSpecie.setDescription(newSpecie.getDescription());
        existingSpecie.setType(newSpecie.getType());
        existingSpecie.setFood(newSpecie.getFood());
        existingSpecie.setHabitat(newSpecie.getHabitat());
        existingSpecie.setStatus(newSpecie.getStatus());
        existingSpecie.setImage(newSpecie.getImage());

        return specieRepository.save(existingSpecie);
    }

    public void deleteSpecie(Long id) {
        specieRepository.deleteById(id);
    }
}
