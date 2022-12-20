package com.github.azalurg.zoomanager.repositories;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.models.Specie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query("Select a from Animal a")
    List<Animal> findAll();

    List<Animal> findBySpecie(Specie specie);
//    List<Animal> findByKeepers(Set(Keeper) keepers);
}
