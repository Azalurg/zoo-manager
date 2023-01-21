package com.github.azalurg.zoomanager.services;

import com.github.azalurg.zoomanager.api.ResourceNotFoundException;
import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.repositories.AnimalRepository;
import com.github.azalurg.zoomanager.repositories.KeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class KeeperService {
    @Autowired
    private final KeeperRepository keeperRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public List<Keeper> findAll() {
        return (List<Keeper>) keeperRepository.findAll();
    }

    public Keeper findById(Long id) {
        return keeperRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Keeper not found"));
    }

    public KeeperService(KeeperRepository keeperRepository) {
        this.keeperRepository = keeperRepository;
    }

    public List<Keeper> getAllKeepers() {
        return (List<Keeper>) keeperRepository.findAll();
    }

    public Keeper createKeeper(Keeper keeper) {
        return keeperRepository.save(keeper);
    }

    public Keeper updateKeeper(Long id, Keeper keeper) {
        Keeper existingKeeper = findById(id);

        existingKeeper.setName(keeper.getName());
        existingKeeper.setSurname(keeper.getSurname());
        existingKeeper.setAddress(keeper.getAddress());
        existingKeeper.setPhone(keeper.getPhone());
        existingKeeper.setEmail(keeper.getEmail());
        existingKeeper.setPassword(keeper.getPassword());
        existingKeeper.setUsername(keeper.getUsername());

        return keeperRepository.save(existingKeeper);
    }

    public void deleteKeeper(Long id) {
        Keeper keeper = findById(id);
        Set<Animal> animals = keeperRepository.findAllKeepersAnimals(id);
        animals.forEach(animal -> animal.removeKeeper(keeper));
        animalRepository.saveAll(animals);
        keeperRepository.delete(keeper);
    }

    public Keeper findByUsername(String username) {
        return keeperRepository.findByUsername(username);
    }
}
