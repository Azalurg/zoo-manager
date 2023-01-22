package com.github.azalurg.zoomanager.api;

import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.services.KeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keepers")
public class KeeperRestController {
    @Autowired
    private KeeperService keeperService;

    @GetMapping
    public List<Keeper> findAll() {
        return keeperService.findAll();
    }

    @GetMapping("/{id}")
    public Keeper findById(@PathVariable Long id) {
        return keeperService.findById(id);
    }

    @PostMapping
    public Keeper createKeeper(@RequestBody Keeper keeper) {
        return keeperService.createKeeper(keeper);
    }
    
    @PutMapping("/{id}")
    public Keeper updateKeeper(@PathVariable Long id, @RequestBody Keeper keeper) {
        return keeperService.updateKeeper(id, keeper);
    }

    @DeleteMapping("/{id}")
    public String deleteKeepers(@PathVariable Long id) {
        keeperService.deleteKeeper(id);
        return "Keeper with ID: " + id + " is deleted";
    }
}
