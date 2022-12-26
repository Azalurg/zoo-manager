package com.github.azalurg.zoomanager.web;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.repositories.AnimalRepository;
import com.github.azalurg.zoomanager.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping("/animals")
public class WebAnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public String getAllAnimals(Model model){
        List<Animal> animalList = this.animalService.getAllAnimals();
        animalList.forEach(animal -> animal.setKeepers(animalService.getKeepersForAnimal(animal.getId())));
        model.addAttribute("animals", animalList);
        return "animals/animals";
    }

}
