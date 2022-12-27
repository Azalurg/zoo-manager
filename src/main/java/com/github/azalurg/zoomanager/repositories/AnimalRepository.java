package com.github.azalurg.zoomanager.repositories;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Keeper;
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

    @Query("SELECT a, h.bornDate FROM Animal a JOIN a.healthCard h ORDER BY h.bornDate")
    List<Animal> findAllAnimalsAndSortByBornDate();

    @Query("SELECT a, s.name FROM Animal a JOIN a.specie s ORDER BY s.name")
    List<Animal> findAllAnimalsAndSortBySpecie();
}
