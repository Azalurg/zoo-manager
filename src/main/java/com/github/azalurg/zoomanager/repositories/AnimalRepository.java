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

    @Query(value = "SELECT s.id as specie, COUNT(*) as count FROM ANIMAL a inner JOIN SPECIE s ON s.id = a.specie_id GROUP BY s.id ORDER BY specie", nativeQuery = true)
    List<Object[]> findAnimalCountBySpecie();


//    @Query("select new com.github.azalurg.zoomanager.repositories.Counter(s.name, count(a)) from Animal a inner join Specie s on a.id = a.specie_id group by s.name")
//    List<Counter> findAnimalCountBySpecie();

//    @Query("SELECT s.name as specieName, COUNT(a.id) as animalCount " +
//            "FROM Specie s " +
//            "LEFT JOIN Animal a ON s.id = a.specie_id " +
//            "GROUP BY s.id")
//    List<Counter> findAnimalCountBySpecie();
}
//    SELECT s.name as Name, COUNT(*)
//        FROM ANIMAL a
//        inner JOIN SPECIE s ON s.id = a.specie_id
//        GROUP BY s.id