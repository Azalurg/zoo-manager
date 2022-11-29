package com.github.azalurg.zoomanager.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Animals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean gender;
    private Date bornDate;
    private Date adoptDate;
    private Float weight;
    private Float height;
    private Float length;
    private Long spiceId;
    private Long descriptionId;

    public Animals() {
    }
}

