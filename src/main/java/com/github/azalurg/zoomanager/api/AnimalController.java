package com.github.azalurg.zoomanager.api;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.repositories.AnimalRepository;
import com.github.azalurg.zoomanager.services.AnimalService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAnimals() {
        return animalService.getAllAnimals();
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.createAnimal(animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        return animalService.updateAnimal(id, animal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
    }
}

//    @GetMapping
//    public String getAnimals(Model model) {
//        List<Animal> animals = (List<Animal>) animalRepository.findAll();
//        model.addAttribute("animals", animals);
//        return "animals/animals";
//    }

