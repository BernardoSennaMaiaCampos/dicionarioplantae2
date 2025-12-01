package com.example.DicionarioPlantae.repository;

import com.example.DicionarioPlantae.entity.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {
}
