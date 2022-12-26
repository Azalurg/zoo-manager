package com.github.azalurg.zoomanager.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
public class Keeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "keepers")
    private List<Animal> animals;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String address;

    private String phone;
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String username;

    public Keeper() {
    }

    public Keeper(String name, String surname, String address, String email, String password, String username) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Keepers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
