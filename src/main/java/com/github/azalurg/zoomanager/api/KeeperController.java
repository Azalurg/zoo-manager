package com.github.azalurg.zoomanager.api;

import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.services.KeeperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keepers")
public class KeeperController {

    private final KeeperService keeperService;

    public KeeperController(KeeperService keeperService) {
        this.keeperService = keeperService;
    }

    @GetMapping
    public List<Keeper> getKeepers() {
        return keeperService.getAllKeepers();
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
    public void deleteKeeper(@PathVariable Long id) {
        keeperService.deleteKeeper(id);
    }
}
