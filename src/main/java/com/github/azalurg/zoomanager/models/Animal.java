package com.github.azalurg.zoomanager.models;

import com.sun.istack.NotNull;
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

    @NotNull
    private String name;

    @NotNull
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
        this.keepers.remove(keeper);
    }
}

