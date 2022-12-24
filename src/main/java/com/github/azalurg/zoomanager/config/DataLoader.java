package com.github.azalurg.zoomanager.config;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.services.AnimalService;
import com.github.azalurg.zoomanager.services.KeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private AnimalService animalService;

    @Autowired
    private KeeperService keeperService;

    @Override
    public void run(String... args) throws Exception {
        // Create keepers
        Keeper keeper1 = new Keeper("John", "Doe", "123 Main St", "john@example.com", "password", "john_doe");
        keeperService.createKeeper(keeper1);

        Keeper keeper2 = new Keeper("Jane", "Doe", "456 Main St", "jane@example.com", "password", "jane_doe");
        keeperService.createKeeper(keeper2);

        // Create animals
        Animal animal1 = new Animal("Lion", new Date(), "A majestic lion");
        animalService.createAnimal(animal1);

        Animal animal2 = new Animal("Tiger", new Date(), "A powerful tiger");
        animalService.createAnimal(animal2);

        Animal animal3 = new Animal("Gorilla", new Date(), "A strong and intelligent gorilla");
        animalService.createAnimal(animal3);

        // Add animals to keepers
        animalService.addKeeperToAnimal(animal1, keeper1);
//        animalService.addKeeperToAnimal(animal1, keeper2);
        animalService.addKeeperToAnimal(animal2, keeper1);
//        animalService.addKeeperToAnimal(animal3, keeper2);
    }
}