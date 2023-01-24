package com.github.azalurg.zoomanager.web;

import com.github.azalurg.zoomanager.custom.Counter;
import com.github.azalurg.zoomanager.custom.SpecieCounterWrapper;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.models.Specie;
import com.github.azalurg.zoomanager.services.AnimalService;
import com.github.azalurg.zoomanager.services.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller()
@RequestMapping("/species")
public class SpecieWebController {

    @Autowired
    private SpecieService specieService;

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public String getAnimalCountBySpecie(@RequestParam(required = false, defaultValue = "") String sessionKey, Model model,  HttpSession session) {
        List<Counter> animalCountBySpecieList = animalService.getAnimalCountBySpecie();
        List<Specie> species = specieService.findAll();
        List<SpecieCounterWrapper> specieCounter = new ArrayList<>();

        species.forEach(s -> {
            Counter c = animalCountBySpecieList.stream().filter(a -> a.getId() == s.getId()).findFirst().orElse(null);
            if (c != null) {
                SpecieCounterWrapper scw = new SpecieCounterWrapper(c.getId(), c.getAmount(), s);
                specieCounter.add(scw);
            }
        });

        boolean loggedIn = false;
        if (!Objects.equals(sessionKey, "")) {
            Keeper keeper = (Keeper) session.getAttribute(sessionKey);
            if (keeper != null) {
                loggedIn = true;
            }
        }

        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("specieCounter", specieCounter);
        System.out.println(specieCounter);
        return "species/species";
    }

    @GetMapping("/add")
    public String addSpecieGet(@RequestParam(required = false, defaultValue = "") String sessionKey, Model model,  HttpSession session) {
        boolean loggedIn = false;
        if (!Objects.equals(sessionKey, "")) {
            Keeper keeper = (Keeper) session.getAttribute(sessionKey);
            if (keeper != null) {
                loggedIn = true;
            }
        }

        if (!loggedIn) {
            return "redirect:/keepers/login";
        }

        model.addAttribute("specie", new Specie());
        return "species/add";
    }

    @PostMapping("/add")
    public String addSpeciePost(@Valid @ModelAttribute("specie") Specie specie, Errors errors, @RequestParam(required = false, defaultValue = "") String sessionKey, Model model, HttpSession session) {
//        boolean loggedIn = false;
//        if (!Objects.equals(sessionKey, "")) {
//            Keeper keeper = (Keeper) session.getAttribute(sessionKey);
//            if (keeper != null) {
//                loggedIn = true;
//            }
//        }
//
//        if (!loggedIn) {
//            return "redirect:/keepers/login";
//        }

        if (errors.hasErrors()) {
            return "species/add";
        }

        Specie newSpecie = new Specie(specie);
        specieService.createSpecie(newSpecie);
        model.addAttribute("specie", new Specie());
        return "redirect:/species";
    }

    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable Long id, Model model) {
        Specie specie = specieService.findById(id);
        if (specie != null) {
            model.addAttribute("specie", specie);
            return "species/update";
        }
        return "species/specie" + id;
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable Long id, @Valid @ModelAttribute("specie") Specie specie, Errors errors, Model model) {
        if (errors.hasErrors()) {
//            System.out.println(errors);
            return "species/update";
        }

        if (specieService.updateSpecie(id,specie) != null) {
            return "redirect:/species";
        }
        return "redirect:/error";
    }

    @GetMapping("/{id}")
    public String getSpecieById(@PathVariable Long id, @RequestParam(required = false, defaultValue = "") String sessionKey, Model model,  HttpSession session) {
        Specie specie = specieService.findById(id);

        boolean loggedIn = false;
        if (!Objects.equals(sessionKey, "")) {
            Keeper keeper = (Keeper) session.getAttribute(sessionKey);
            if (keeper != null) {
                loggedIn = true;
            }
        }

        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("specie", specie);
        model.addAttribute("animals", animalService.findBySpecie(specie.getId()));
        return "species/specie";
    }
}
