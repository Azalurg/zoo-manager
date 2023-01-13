package com.github.azalurg.zoomanager.api;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalRestController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Long id) {
        return animalService.findById(id);
    }

    @PostMapping("/{keeperId}")
    public Animal createAnimal(@RequestBody Animal animal, @PathVariable Long keeperId) {
        return animalService.createAnimal(animal, keeperId);
    }

    @PatchMapping("/{id}/keeper/{keeperId}")
    public Animal addKeeper(@PathVariable Long id, @PathVariable Long keeperId) {
        return animalService.addKeeper(id, keeperId);
    }

    @PatchMapping("/{id}/healthcard/{healthCardId}")
    public Animal setHealthCard(@PathVariable Long id, @PathVariable Long healthCardId) {
        return animalService.setHealthCard(id, healthCardId);
    }

    @PatchMapping("/{id}/specie/{specieId}")
    public Animal setSpecie(@PathVariable Long id, @PathVariable Long specieId) {
        return animalService.setSpecie(id, specieId);
    }

    //Todo: add put and delete methods
}
