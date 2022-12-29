package com.github.azalurg.zoomanager.web;

import com.github.azalurg.zoomanager.custom.Counter;
import com.github.azalurg.zoomanager.custom.SpecieCounterWrapper;
import com.github.azalurg.zoomanager.models.Specie;
import com.github.azalurg.zoomanager.services.AnimalService;
import com.github.azalurg.zoomanager.services.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.*;

@Controller()
@RequestMapping("/species")
public class WebSpecieController {

    @Autowired
    private SpecieService specieService;

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public String getAnimalCountBySpecie(Model model) {
        List<Counter> animalCountBySpecieList = animalService.getAnimalCountBySpecie();
        List<Specie> species = specieService.getAll();
        List<SpecieCounterWrapper> specieCounter = new ArrayList<>();

        species.forEach(s -> {
            Counter c = animalCountBySpecieList.stream().filter(a -> a.getId() == s.getId()).findFirst().orElse(null);
            if (c != null) {
                SpecieCounterWrapper scw = new SpecieCounterWrapper(c.getId(), c.getAmount(), s);
                specieCounter.add(scw);
            }
        });

        model.addAttribute("specieCounter", specieCounter);
        System.out.println(specieCounter);
        return "species/species";
    }
}
