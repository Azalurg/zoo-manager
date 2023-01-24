package com.github.azalurg.zoomanager.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Specie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Column(name="name", unique = true, nullable = false)
    private String name;

    @NotNull(message = "Description cannot be null")
    private String description;

    @NotNull(message = "Type cannot be null")
    private String type;

    @NotNull(message = "Food cannot be null")
    private String food;

    @NotNull(message = "Habitat cannot be null")
    private String habitat;

    @NotNull(message = "Status cannot be null")
    private String status;

    @NotNull(message = "Image cannot be null")
    private String image;

    public Specie() {
    }

    public Specie(String name, String description, String type, String food, String habitat, String status, String image) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.food = food;
        this.habitat = habitat;
        this.status = status;
        this.image = image;
    }

    public Specie(Specie specie) {
        this.name = specie.getName();
        this.description = specie.getDescription();
        this.type = specie.getType();
        this.food = specie.getFood();
        this.habitat = specie.getHabitat();
        this.status = specie.getStatus();
        this.image = specie.getImage();
    }

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", food='" + food + '\'' +
                ", habitat='" + habitat + '\'' +
                ", status='" + status + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
