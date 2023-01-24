package com.github.azalurg.zoomanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
public class Keeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "keepers")
    private Set<Animal> animals = new HashSet<>();

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Surname cannot be null")
    private String surname;

    @NotNull(message = "Address cannot be null")
    private String address;

    @NotNull(message = "Phone cannot be null")
    @Pattern(regexp = "^\\+?\\d{10,12}$", message = "Phone number is not valid")
    private String phone;

    @NotNull(message = "Email cannot be null")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email is not valid")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Password is not valid")
    private String password;

    @NotNull(message = "Username cannot be null")
    @Column(unique = true, nullable = false)
    private String username;

    public Keeper(String name, String surname, String address, String email, String password, String username) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
