package com.github.azalurg.zoomanager.models;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "HealthCards")
public class HealthCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pesez;
    private String description;
    private Float weight;
    private Float height;
    private Float length;
    private Boolean gender;
    private Date bornDate;

    public HealthCard() {
    }

    public Long getId() {
        return id;
    }

    public Long getPesez() {
        return pesez;
    }

    public void setPesez(Long pesez) {
        this.pesez = pesez;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
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
