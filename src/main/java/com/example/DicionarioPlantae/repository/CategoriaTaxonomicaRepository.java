package com.example.DicionarioPlantae.repository;

import com.example.DicionarioPlantae.entity.CategoriaTaxonomica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaTaxonomicaRepository extends JpaRepository<CategoriaTaxonomica, Integer> {
}
