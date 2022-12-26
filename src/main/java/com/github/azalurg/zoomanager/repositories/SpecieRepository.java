package com.github.azalurg.zoomanager.repositories;

import com.github.azalurg.zoomanager.models.Specie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecieRepository extends JpaRepository<Specie, Long> {
}