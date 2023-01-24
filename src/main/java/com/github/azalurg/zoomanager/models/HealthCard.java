package com.github.azalurg.zoomanager.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.github.azalurg.zoomanager.custom.Pesez;
import com.github.azalurg.zoomanager.custom.PesezType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class HealthCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Pesez cannot be null")
//    @Pattern(regexp = "^[0-9]{11}$", message = "Pesez must be 10 digits")
//    @PesezType
    private Long pesez;

    @NotNull(message = "Description cannot be null")
    private String description;

    @NotNull(message = "Weight cannot be null")
//    @Size(min = 0, max = 9999, message = "Weight must be greater than 0")
    private Float weight;

    @NotNull(message = "Height cannot be null")
//    @Size(min = 0, max = 9999, message = "Height must be greater than 0")
    private Float height;

    @NotNull(message = "Length cannot be null")
//    @Size(min = 0, max = 9999, message = "Length must be greater than 0")
    private Float length;

    @NotNull(message = "Gender cannot be null")
    private Boolean gender;

//    @NotNull(message = "Born date cannot be null")
//    @Temporal(TemporalType.DATE)
    private Date bornDate;

    public HealthCard(Long pesez, String description, Float weight, Float height, Float length, Boolean gender, Date bornDate) {
        this.pesez = pesez;
        this.description = description;
        this.weight = weight;
        this.height = height;
        this.length = length;
        this.gender = gender;
        this.bornDate = bornDate;
    }
}
