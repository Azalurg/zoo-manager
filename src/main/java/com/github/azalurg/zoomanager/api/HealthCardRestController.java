package com.github.azalurg.zoomanager.api;

import com.github.azalurg.zoomanager.models.HealthCard;
import com.github.azalurg.zoomanager.services.HealthCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/healthcards")
public class HealthCardRestController {
    @Autowired
    private HealthCardService healthCardService;

    @GetMapping
    public List<HealthCard> findAll() {
        return healthCardService.findAll();
    }

    @GetMapping("/{id}")
    public HealthCard findById(@PathVariable Long id) {
        return healthCardService.findById(id);
    }

    @PostMapping
    public HealthCard createKeeper(@RequestBody HealthCard healthCard) {
        return healthCardService.createHealthCard(healthCard);
        //Todo: fix this method
    }

    @PutMapping("/{id}")
    public HealthCard updateHealthCard(@PathVariable Long id, @RequestBody HealthCard healthCard) {
        return healthCardService.updateHealthCard(id, healthCard);
    }

    @DeleteMapping("/{id}")
    public void deleteHealthCards(@PathVariable Long id) {
        healthCardService.deleteHealthCard(id);
    }

}
