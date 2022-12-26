package com.github.azalurg.zoomanager.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Specie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String type;

    @NotNull
    private String food;

    @NotNull
    private String habitat;

    @NotNull
    private String status;

    @NotNull
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
