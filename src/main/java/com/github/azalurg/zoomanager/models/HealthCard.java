package com.github.azalurg.zoomanager.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class HealthCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long pesez;

    @NotNull
    private String description;

    @NotNull
    private Float weight;

    @NotNull
    private Float height;

    @NotNull
    private Float length;

    @NotNull
    private Boolean gender;

    @NotNull
    private Date bornDate;

    public HealthCard() {
    }

    public HealthCard(Long pesez, String description, Float weight, Float height, Float length, Boolean gender, Date bornDate) {
        this.pesez = pesez;
        this.description = description;
        this.weight = weight;
        this.height = height;
        this.length = length;
        this.gender = gender;
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        return "HealthCard{" +
                "id=" + id +
                ", pesez=" + pesez +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", length=" + length +
                ", gender=" + gender +
                ", bornDate=" + bornDate +
                '}';
    }
}
