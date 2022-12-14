package com.github.azalurg.zoomanager.models;

import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
//@Table(name = "Animals")
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
    @JoinTable(name="AnimalsKeepers")
    private Set<Keeper> keepers;

    @NotNull
    private String name;

    @NotNull
    private Date adoptDate;

    private String description;
    private String image;

//    ------------------------------

    public Animal() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAdoptDate() {
        return adoptDate;
    }

    public void setAdoptDate(Date adoptDate) {
        this.adoptDate = adoptDate;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) { this.specie = specie; }

    public HealthCard getHealthCard() {
        return this.healthCard;
    }

    public void setHealthCard(HealthCard healthCard) {
        this.healthCard = healthCard;
    }

    public Set<Keeper> getKeepers() {
        return keepers;
    }

    public void setKeepers(Set<Keeper> keepers) {
        this.keepers = keepers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

