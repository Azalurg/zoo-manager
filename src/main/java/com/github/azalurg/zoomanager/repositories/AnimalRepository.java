package com.github.azalurg.zoomanager.repositories;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Keeper;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
    @Query("SELECT k FROM Keeper k JOIN k.animals a WHERE a.id = :animalId")
    List<Keeper> findKeepersByAnimalId(@Param("animalId") Long animalId);

    @Query("SELECT a FROM Animal a ORDER BY a.name")
    List<Animal> findAllAnimalsAndSortByName();

    @Query("SELECT a FROM Animal a ORDER BY a.id")
    List<Animal> findAllAnimalsAndSortById();
}
