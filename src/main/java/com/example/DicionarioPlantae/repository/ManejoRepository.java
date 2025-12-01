package com.example.DicionarioPlantae.repository;

import com.example.DicionarioPlantae.entity.Manejo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManejoRepository extends JpaRepository<Manejo, Integer> {
}
