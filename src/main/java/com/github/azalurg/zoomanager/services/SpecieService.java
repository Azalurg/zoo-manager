package com.github.azalurg.zoomanager.services;

import com.github.azalurg.zoomanager.models.Specie;
import com.github.azalurg.zoomanager.repositories.SpecieRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SpecieService {
    private final SpecieRepository specieRepository;

    public SpecieService(SpecieRepository specieRepository) {
        this.specieRepository = specieRepository;
    }

    public List<Specie> getAll() {
        return specieRepository.findAll();
    }

    public Specie findSpecieById(Long id) {
        return specieRepository.findById(id).orElse(null);
    }

    public Specie createSpecie(Specie specie) {
        return specieRepository.save(specie);
    }

    public void deleteSpiece(Specie specie) {
        specieRepository.delete(specie);
    }
}
