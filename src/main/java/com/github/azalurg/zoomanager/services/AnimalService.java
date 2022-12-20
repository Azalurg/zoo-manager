package com.github.azalurg.zoomanager.services;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AnimalService {
    final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Iterable<Animal> findAllAnimals(){
        return animalRepository.findAll();
    }

    public void test() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Animal animal1 = new Animal("Sloniu", dateFormat.parse("19/05/1956"));
        Animal animal2 = new Animal("Strusiu", dateFormat.parse("13/11/1957"));
        Animal animal3 = new Animal("Żółwiu", dateFormat.parse("02/01/2004"));

        this.animalRepository.save(animal1);
        this.animalRepository.save(animal2);
        this.animalRepository.save(animal3);

        System.out.println(this.animalRepository.findAll());
    }
}
