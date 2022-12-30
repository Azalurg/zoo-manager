package com.github.azalurg.zoomanager.api;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.services.AnimalService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class RestAnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> getAnimals() {
        List<Animal> animalList = animalService.getAllAnimals("id");
        animalList.forEach(animal -> {
            List<Keeper> k = animalService.getKeepersForAnimal(animal.getId());
            k.forEach(keeper -> keeper.setAnimals(null));
            animal.setKeepers(k);
        });
        return animalList;
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        List<Keeper> k = animalService.getKeepersForAnimal(id);
        k.forEach(keeper -> keeper.setAnimals(null));
        animal.setKeepers(k);
        return animal;
    }
}
