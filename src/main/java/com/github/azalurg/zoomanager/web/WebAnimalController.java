package com.github.azalurg.zoomanager.web;

import com.github.azalurg.zoomanager.custom.Counter;
import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Specie;
import com.github.azalurg.zoomanager.services.AnimalService;
import com.github.azalurg.zoomanager.services.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller()
@RequestMapping("/animals")
public class WebAnimalController {
    @Autowired
    private AnimalService animalService;

    @Autowired
    private SpecieService specieService;

    @GetMapping
    public String getAllAnimals(@RequestParam(required = false, defaultValue = "id") String sortBy, Model model){
        List<Animal> animalList = this.animalService.getAllAnimals(sortBy);
        animalList.forEach(animal -> animal.setKeepers(animalService.getKeepersForAnimal(animal.getId())));
        model.addAttribute("animals", animalList);
        return "animals/animals";
    }

    @GetMapping("/{id}")
    public String getAnimalById(@PathVariable Long id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        animal.setKeepers(animalService.getKeepersForAnimal(id));
        model.addAttribute("animal", animal);
        return "animals/animal";
    }

}
