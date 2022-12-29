package com.github.azalurg.zoomanager.services;

import com.github.azalurg.zoomanager.api.ResourceNotFoundException;
import com.github.azalurg.zoomanager.custom.Counter;
import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals(String sort) {
        sort = sort.toUpperCase();

        switch (sort){
            case "NAME":
                return animalRepository.findAllAnimalsAndSortByName();
            case "BORN_DATE":
                return animalRepository.findAllAnimalsAndSortByBornDate();
            case "SPECIE":
                return animalRepository.findAllAnimalsAndSortBySpecie();
            default:
                return animalRepository.findAllAnimalsAndSortById();
        }
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

    public List<Keeper> getKeepersForAnimal(Long animalId) {
        return animalRepository.findKeepersByAnimalId(animalId);
    }

    public void addKeeperToAnimal(Animal animal, Keeper keeper) {
        List<Keeper> keepers = animalRepository.findKeepersByAnimalId(animal.getId());
        for (Keeper k : keepers) {
            if (Objects.equals(k.getId(), keeper.getId())) {
                return;
            }
        }
        keepers.add(keeper);
        animal.setKeepers(keepers);
        animalRepository.save(animal);
    }

    public List<Counter> getAnimalCountBySpecie() {
        List<Counter> sc = new ArrayList<>();
        animalRepository.findAnimalCountBySpecie().forEach(x -> {
            Counter s = new Counter();
            s.setId((BigInteger) x[0]);
            s.setAmount((BigInteger) x[1]);
            sc.add(s);
        });
        return sc;
    }
}
