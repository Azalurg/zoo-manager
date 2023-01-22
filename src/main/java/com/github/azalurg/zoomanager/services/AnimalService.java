package com.github.azalurg.zoomanager.services;

import com.github.azalurg.zoomanager.api.ResourceNotFoundException;
import com.github.azalurg.zoomanager.custom.Counter;
import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.HealthCard;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.models.Specie;
import com.github.azalurg.zoomanager.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@Transactional
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private KeeperService keeperService;

    @Autowired
    private HealthCardService healthCardService;

    @Autowired
    private  SpecieService specieService;

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal not found"));
    }

    public Animal addKeeper(Long id, Long keeperId) {
        Animal animal = findById(id);
        Keeper keeper = keeperService.findById(keeperId);
        animal.addKeeper(keeper);
        return animalRepository.save(animal);
    }

    public Animal setHealthCard(Long id, Long healthCardId) {
        Animal animal = findById(id);
        HealthCard healthCard = healthCardService.findById(healthCardId);
        animal.setHealthCard(healthCard);
        return animalRepository.save(animal);
    }

    public Animal setSpecie(Long id, Long specieId) {
        Animal animal = findById(id);
        Specie specie = specieService.findById(specieId);
        animal.setSpecie(specie);
        return animalRepository.save(animal);
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

    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal createAnimal(Animal animal, Long keeperId) {
        Keeper keeper = keeperService.findById(keeperId);
        animal.addKeeper(keeper);
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Long id, Animal newAnimal) {
        Animal existingAnimal = findById(id);

        existingAnimal.setName(newAnimal.getName());
        existingAnimal.setAdoptDate(newAnimal.getAdoptDate());
        existingAnimal.setDescription(newAnimal.getDescription());
        existingAnimal.setImage(newAnimal.getImage());

        return animalRepository.save(existingAnimal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public Set<Keeper> getKeepersForAnimal(Long animalId) {
        return animalRepository.findKeepersByAnimalId(animalId);
    }

    public void addKeeperToAnimal(Animal animal, Keeper keeper) {
        animal.addKeeper(keeper);
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
