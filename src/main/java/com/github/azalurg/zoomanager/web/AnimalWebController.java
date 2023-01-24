package com.github.azalurg.zoomanager.web;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.HealthCard;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.services.AnimalService;
import com.github.azalurg.zoomanager.services.HealthCardService;
import com.github.azalurg.zoomanager.services.KeeperService;
import com.github.azalurg.zoomanager.services.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller()
@RequestMapping("/animals")
public class AnimalWebController {
    @Autowired
    private AnimalService animalService;

    @Autowired
    private SpecieService specieService;

    @Autowired
    private KeeperService keeperService;

    @Autowired
    private HealthCardService healthCardService;

    @GetMapping
    public String getAllAnimals(@RequestParam(required = false, defaultValue = "id") String sortBy, @RequestParam(required = false, defaultValue = "") String sessionKey, Model model, HttpSession session){
        List<Animal> animalList = this.animalService.getAllAnimals(sortBy);

        boolean loggedIn = false;
        if (!Objects.equals(sessionKey, "")) {
            Keeper keeper = (Keeper) session.getAttribute(sessionKey);
            if (keeper != null) {
                loggedIn = true;
            }
        }

        model.addAttribute("loggedIn", loggedIn);

        model.addAttribute("animals", animalList);
        return "animals/animals";
    }

    @GetMapping("/add")
    public String addAnimalGet(@RequestParam(required = false, defaultValue = "") String sessionKey, Model model,  HttpSession session) {
        boolean loggedIn = false;
        Long keeperId = null;
        if (!Objects.equals(sessionKey, "")) {
            Keeper keeper = (Keeper) session.getAttribute(sessionKey);
            if (keeper != null) {
                loggedIn = true;
                keeperId = keeper.getId();
            }
        }

        if (!loggedIn) {
            return "redirect:/keepers/login";
        }


        model.addAttribute("species", specieService.findAll());
        model.addAttribute("keepers", keeperService.findAll());
        model.addAttribute("healthCard", new HealthCard());
        model.addAttribute("currentId", keeperId);
        model.addAttribute("animal", new Animal());
        return "animals/add";
    }

    @PostMapping("/add")
    public String addAnimalPost(@Valid @ModelAttribute("animal") Animal animal, Errors errors, @RequestParam(required = false, defaultValue = "") String sessionKey, Model model, HttpSession session) {
        if (errors.hasErrors()) {
            return "animals/add";
        }

        animalService.createAnimal(animal);
        model.addAttribute("animal", new Animal());
        return "redirect:/animals";
    }

    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable Long id, Model model) {
        Animal animal = animalService.findById(id);
        if (animal != null) {
            model.addAttribute("animal", animal);
            return "animals/update";
        }
        return "animals/animal" + id;
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable Long id, @Valid @ModelAttribute("animal") Animal animal, Errors errors, Model model) {
        if (errors.hasErrors()) {
//            System.out.println(errors);
            return "animals/update";
        }

        if (animalService.updateAnimal(id,animal) != null) {
            return "redirect:/animals";
        }
        return "redirect:/error";
    }


    @GetMapping("/{id}")
    public String getAnimalById(@PathVariable Long id, Model model) {
        Animal animal = animalService.findById(id);
        animal.setKeepers(animalService.getKeepersForAnimal(id));
        model.addAttribute("animal", animal);
        return "animals/animal";
    }

}
