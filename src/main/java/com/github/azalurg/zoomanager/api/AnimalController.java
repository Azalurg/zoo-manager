package com.github.azalurg.zoomanager.api;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.services.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {
    final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/api/animals")
    Iterable<Animal> allAnimals(){
        return animalService.findAllAnimals();
    }
}
