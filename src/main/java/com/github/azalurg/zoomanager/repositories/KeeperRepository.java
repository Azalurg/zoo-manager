package com.github.azalurg.zoomanager.repositories;

import com.github.azalurg.zoomanager.models.Keeper;
import org.springframework.data.repository.CrudRepository;

public interface KeeperRepository extends CrudRepository<Keeper, Long> {
    Keeper findByUsername(String username);
}
