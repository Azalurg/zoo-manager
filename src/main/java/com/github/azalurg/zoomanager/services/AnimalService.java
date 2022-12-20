package com.github.azalurg.zoomanager.services;

import com.github.azalurg.zoomanager.api.ResourceNotFoundException;
import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() {
        return (List<Animal>) animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal not found"));
    }

    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Long id, Animal animal) {
        Animal existingAnimal = getAnimalById(id);
        existingAnimal.setName(animal.getName());
        existingAnimal.setDescription(animal.getDescription());
        return animalRepository.save(existingAnimal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public void addKeeperToAnimal(Animal animal, Keeper keeper) {
        animal.addKeeper(keeper);
        animalRepository.save(animal);
    }
}
