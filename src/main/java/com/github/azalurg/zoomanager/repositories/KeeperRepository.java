package com.github.azalurg.zoomanager.repositories;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Keeper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface KeeperRepository extends CrudRepository<Keeper, Long> {
    Keeper findByUsername(String username);

    @Query("SELECT DISTINCT a FROM Animal a JOIN FETCH a.keepers k WHERE k.id = :keeperId")
    Set<Animal> findAllKeepersAnimals(@Param("keeperId") Long keeperId);
}
