package com.github.azalurg.zoomanager.config;

import com.github.azalurg.zoomanager.models.Animal;
import com.github.azalurg.zoomanager.models.HealthCard;
import com.github.azalurg.zoomanager.models.Keeper;
import com.github.azalurg.zoomanager.models.Specie;
import com.github.azalurg.zoomanager.services.AnimalService;
import com.github.azalurg.zoomanager.services.HealthCardService;
import com.github.azalurg.zoomanager.services.KeeperService;
import com.github.azalurg.zoomanager.services.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

//@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private AnimalService animalService;

    @Autowired
    private KeeperService keeperService;

    @Autowired
    private SpecieService specieService;

    @Autowired
    private HealthCardService healthCardService;

    private final Random random = new Random();

    private Date getRandomDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1950 + random.nextInt(50));
        calendar.set(Calendar.MONTH, random.nextInt(12));
        calendar.set(Calendar.DAY_OF_MONTH, 1 + random.nextInt(calendar.getActualMaximum(Calendar.DAY_OF_MONTH)));

        return calendar.getTime();
    }

    @Override
    public void run(String... args) throws Exception {
        // Create spices
        Specie specie1 = new Specie("Lion", "Large carnivorous mammal", "Mammal", "Meat", "Savannah", "Vulnerable", "https://images.pexels.com/photos/2220337/pexels-photo-2220337.jpeg?auto=compress&cs=tinysrgb&w=1280&h=720&dpr=1");
        Specie specie2 = new Specie("Gorilla", "Large ape", "Mammal", "Plants", "Rainforest", "Endangered", "https://images.pexels.com/photos/913652/pexels-photo-913652.jpeg?auto=compress&cs=tinysrgb&w=1280&h=720&dpr=1");
        Specie specie3 = new Specie("Penguin", "Aquatic bird", "Bird", "Fish", "Antarctica", "Least Concern", "https://images.pexels.com/photos/209096/pexels-photo-209096.jpeg?auto=compress&cs=tinysrgb&w=1280&h=720&dpr=1");
//        Specie specie4 = new Specie("Cheetah", "Fastest land animal", "Mammal", "Meat", "Savannah", "Vulnerable", "https://images.pexels.com/photos/2793479/pexels-photo-2793479.jpeg?auto=compress&cs=tinysrgb&w=1280&h=720&dpr=1");
//        Specie specie5 = new Specie("Panda", "Symbol of peace", "Mammal", "Bamboo", "Mountainous regions", "Endangered", "https://images.pexels.com/photos/1661535/pexels-photo-1661535.jpeg?auto=compress&cs=tinysrgb&w=1280&h=720&dpr=1");
//        Specie specie6 = new Specie("Kangaroo", "A national symbol of Australia", "Mammal", "Plants", "Australia", "Least Concern", "https://images.pexels.com/photos/2573494/pexels-photo-2573494.jpeg?auto=compress&cs=tinysrgb&w=1280&h=720&dpr=1");
//        Specie specie7 = new Specie("Otter", "Semi-aquatic mammal", "Mammal", "Fish", "Coastal areas", "Vulnerable", "https://images.pexels.com/photos/53510/head-details-otter-close-up-53510.jpeg?auto=compress&cs=tinysrgb&w=1280&h=720&dpr=1");
//        Specie specie8 = new Specie("Toucan", "Brightly colored bird", "Bird", "Fruit", "Tropical rainforest", "Least Concern", "https://images.pexels.com/photos/12187520/pexels-photo-12187520.jpeg?auto=compress&cs=tinysrgb&w=1280&h=720&dpr=1");
//        Specie specie9 = new Specie("Giraffe", "Tallest living terrestrial animal", "Mammal", "Leaves", "Savannah", "Vulnerable", "https://images.pexels.com/photos/34098/south-africa-hluhluwe-giraffes-pattern.jpg?auto=compress&cs=tinysrgb&w=1280&h=720&dpr=1");
//        Specie specie10 = new Specie("Pelican", "Large waterbird", "Bird", "Fish", "Coastal areas", "Least Concern", "https://images.pexels.com/photos/158986/pexels-photo-158986.jpeg?auto=compress&cs=tinysrgb&w=1280&h=720&dpr=1");
        specieService.createSpecie(specie1);
        specieService.createSpecie(specie2);
        specieService.createSpecie(specie3);
//        specieService.createSpecie(specie4);
//        specieService.createSpecie(specie5);
//        specieService.createSpecie(specie6);
//        specieService.createSpecie(specie7);
//        specieService.createSpecie(specie8);
//        specieService.createSpecie(specie9);
//        specieService.createSpecie(specie10);

//        List<Specie> species = Arrays.asList(specie1, specie2, specie3, specie4, specie5, specie6, specie7, specie8, specie9, specie10);
        List<Specie> species = Arrays.asList(specie1, specie2, specie3);

        // Create keepers
        Keeper keeper1 = new Keeper("John", "Doe", "123 Main St", "john@example.com", "password", "john_doe");
        Keeper keeper2 = new Keeper("Jane", "Doe", "456 Main St", "jane@example.com", "password", "jane_doe");
        Keeper keeper3 = new Keeper("Bob", "Kel", "789 Main St", "bob@example.com", "password", "bob_kel");
//        Keeper keeper4 = new Keeper("Alex", "Smith", "111 Main St", "alex@example.com", "password", "alex_smith");
//        Keeper keeper5 = new Keeper("Emma", "Johnson", "222 Main St", "emma@example.com", "password", "emma_johnson");
//        Keeper keeper6 = new Keeper("Charlie", "Williams", "333 Main St", "charlie@example.com", "password", "charlie_williams");
//        Keeper keeper7 = new Keeper("Olivia", "Jones", "444 Main St", "olivia@example.com", "password", "olivia_jones");
//        Keeper keeper8 = new Keeper("Adam", "Brown", "555 Main St", "adam@example.com", "password", "adam_brown");
//        Keeper keeper9 = new Keeper("Lily", "Davis", "666 Main St", "lily@example.com", "password", "lily_davis");
//        Keeper keeper10 = new Keeper("Ethan", "Moore", "777 Main St", "ethan@example.com", "password", "ethan_moore");
        keeperService.createKeeper(keeper1);
        keeperService.createKeeper(keeper2);
        keeperService.createKeeper(keeper3);
//        keeperService.createKeeper(keeper4);
//        keeperService.createKeeper(keeper5);
//        keeperService.createKeeper(keeper6);
//        keeperService.createKeeper(keeper7);
//        keeperService.createKeeper(keeper8);
//        keeperService.createKeeper(keeper9);
//        keeperService.createKeeper(keeper10);

//        List<Keeper> keepers = Arrays.asList(keeper1, keeper2, keeper3, keeper4, keeper5, keeper6, keeper7, keeper8, keeper9, keeper10);
        List<Keeper> keepers = Arrays.asList(keeper1, keeper2, keeper3);

        // Create animals
//        List<String> namesList = Arrays.asList(
//                "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Mia", "Charlotte", "Amelia", "Emily", "Abigail",
//                "Avery", "Ella", "Harper", "Lily", "Evelyn", "Aria", "Aubrey", "Chloe", "Zoey", "Natalie",
//                "Hannah", "Lillian", "Addison", "Elizabeth", "Mila","Leah", "Sofia", "Aaliyah", "Avery", "Ella",
//                "Natalie", "Hannah", "Lillian", "Addison", "Elizabeth","Mila", "Leah", "Sofia", "Aaliyah", "Kaylee",
//                "Layla", "Harper", "Aubree", "Lyla", "Makayla","Peyton", "Riley", "Grace", "Brooklyn", "Sarah",
//                "Avery", "Ella", "Natalie", "Hannah", "Lillian","Edison", "Elizabeth", "Mila", "Leah", "Sofia",
//                "Aaliyah", "Kaylee", "Layla", "Harper", "Aubree","Lyla", "Makayla", "Peyton", "Riley", "Grace",
//                "Brooklyn", "Sarah", "Avery", "Ella", "Natalie","Hannah", "Lillian", "Addison", "Elizabeth", "Mila",
//                "Leah", "Sofia", "Aaliyah", "Kaylee", "Layla", "Harper", "Aubree", "Lyla", "Makayla", "Peyton");
        List<String> namesList = Arrays.asList("Emma", "Olivia", "Ava", "Isabella", "Sophia", "Mia", "Charlotte", "Amelia", "Emily", "Abigail");

        List<Animal> animals = new ArrayList<>();
        namesList.forEach(name -> {
            // 10
            int s = this.random.nextInt(3);
            int ks = this.random.nextInt(2)+1;
            HealthCard h = new HealthCard(
                    (long) Math.round(this.random.nextLong()*100000),
                    "",
                    (float) (Math.round(this.random.nextFloat()*10000)/100),
                    (float) (Math.round(this.random.nextFloat()*10000)/100),
                    (float) (Math.round(this.random.nextFloat()*10000)/100),
                    this.random.nextBoolean(),
                    getRandomDate());
            healthCardService.createHealthCard(h);
            Animal a = animalService.createAnimal(new Animal(name, new Date(), species.get(s), h));
            for(int i =0; i < ks; i++){
                int k = this.random.nextInt(3);
                animalService.addKeeperToAnimal(a, keepers.get(k));
            }
        });
    }
}