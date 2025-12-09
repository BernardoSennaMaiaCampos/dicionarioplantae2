package com.example.DicionarioPlantae.repository;

import com.example.DicionarioPlantae.dto.response.CategoriaTaxonomicaDTOResponse;
import com.example.DicionarioPlantae.entity.CategoriaTaxonomica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoriaTaxonomicaRepository extends JpaRepository<CategoriaTaxonomica, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE CategoriaTaxonomica c SET c.status = -1 WHERE c.id = :id")
    void apagarCategoriaTaxonomica (@Param("id")Integer id);

    @Query("SELECT c FROM CategoriaTaxonomica c WHERE c.status >= 0")
    List<CategoriaTaxonomicaDTOResponse> listarCategoriaTaxonomica();

    @Query("SELECT c FROM CategoriaTaxonomica c WHERE c.id = :id")
    CategoriaTaxonomica obterCategoriaTaxonomicaPorId (@Param("id")Integer id);


}
