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

    public void deleteSpiece(Specie specie) {
        specieRepository.delete(specie);
    }
}
