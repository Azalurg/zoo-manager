package com.github.azalurg.zoomanager.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Nullable
    private Specie specie;

    @OneToOne
    @Nullable
    private HealthCard healthCard;

    @ManyToMany
    @JoinTable(
            name = "animals_keepers",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "keeper_id"))
    private Set<Keeper> keepers = new HashSet<>();

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Adopt date cannot be null")
    @Temporal(TemporalType.DATE)
    private Date adoptDate;

    @Nullable
    private String description;

    @Nullable
    private String image;

//    ------------------------------

    public Animal(String name, Date adoptDate, Specie specie, HealthCard healthCard) {
        this.name = name;
        this.adoptDate = adoptDate;
        this.specie = specie;
        this.healthCard = healthCard;
    }

    public void addKeeper(Keeper keeper) {
        this.keepers.add(keeper);
    }

    public void removeKeeper(Keeper keeper) {
        System.out.println("Removing keeper " + this.keepers);
        this.keepers.remove(keeper);
        System.out.println("Keeper removed" + this.keepers);
    }
}

