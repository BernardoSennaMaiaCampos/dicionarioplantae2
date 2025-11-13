package com.example.DicionarioPlantae.repository;

import com.example.DicionarioPlantae.entity.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Integer> {
}
