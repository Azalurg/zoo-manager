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

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.createAnimal(animal);
    }

    @PatchMapping("/{id}/keeper/{keeperId}")
    public Animal addKeeper(@PathVariable Long id, @PathVariable Long keeperId) {
        return animalService.addKeeper(id, keeperId);
    }

    @PatchMapping("/{id}/healthcard/{healthCardId}")
    public Animal setHealthCard(@PathVariable Long id, @PathVariable Long healthCardId) {
        return animalService.setHealthCard(id, healthCardId);
    }

    //Todo: add put and delete methods
}
