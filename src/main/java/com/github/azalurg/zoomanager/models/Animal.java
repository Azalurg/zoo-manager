package com.github.azalurg.zoomanager.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
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
    private List<Keeper> keepers;

    @NotNull
    private String name;

    @NotNull
    private Date adoptDate;

    @Nullable
    private String description;
    @Nullable
    private String image;

//    ------------------------------

    public Animal(String name, Date adoptDate, Specie specie){
        this.name = name;
        this.adoptDate = adoptDate;
        this.specie = specie;
    }

    public Animal() {
    }

    public void addKeeper(Keeper keeper) {
        if (!keepers.contains(keeper)){
            this.keepers.add(keeper);
        }

    }

    public void removeKeeper(Keeper keeper) {
        this.keepers.remove(keeper);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", specie=" + specie +
                ", healthCard=" + healthCard +
                ", keepers=" + keepers +
                ", name='" + name + '\'' +
                ", adoptDate=" + adoptDate +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

