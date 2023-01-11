package com.github.azalurg.zoomanager.services;

import com.github.azalurg.zoomanager.api.ResourceNotFoundException;
import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.repositories.KeeperRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KeeperService {

    private final KeeperRepository keeperRepository;

    public KeeperService(KeeperRepository keeperRepository) {
        this.keeperRepository = keeperRepository;
    }

    public List<Keeper> getAllKeepers() {
        return (List<Keeper>) keeperRepository.findAll();
    }

    public Keeper getKeeperById(Long id) {
        return keeperRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Keeper not found"));
    }

    public Keeper createKeeper(Keeper keeper) {
        return keeperRepository.save(keeper);
    }

    public Keeper updateKeeper(Keeper keeper) {
        Long id = keeper.getId();
        Keeper existingKeeper = getKeeperById(id);
        existingKeeper.setName(keeper.getName());
        existingKeeper.setSurname(keeper.getSurname());
        existingKeeper.setAddress(keeper.getAddress());
        existingKeeper.setPhone(keeper.getPhone());
        existingKeeper.setEmail(keeper.getEmail());
        existingKeeper.setPassword(keeper.getPassword());
        existingKeeper.setUsername(keeper.getUsername());
        return keeperRepository.save(existingKeeper);
    }

    public void deleteKeeper(Long id) {
        keeperRepository.deleteById(id);
    }

    public Keeper findByUsername(String username) {
        return keeperRepository.findByUsername(username);
    }
}
