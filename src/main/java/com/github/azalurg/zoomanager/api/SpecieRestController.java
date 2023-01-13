package com.github.azalurg.zoomanager.api;

import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.models.Specie;
import com.github.azalurg.zoomanager.services.KeeperService;
import com.github.azalurg.zoomanager.services.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/species")
public class SpecieRestController {
    @Autowired
    private SpecieService specieService;

    @GetMapping
    public List<Specie> findAll() {
        return specieService.findAll();
    }

    @GetMapping("/{id}")
    public Specie findById(@PathVariable Long id) {
        return specieService.findById(id);
    }

    @PostMapping
    public Specie createKeeper(@RequestBody Specie specie) {
        return specieService.createSpecie(specie);
        //Todo: fix this method
    }

    //Todo: add put and delete methods
}
