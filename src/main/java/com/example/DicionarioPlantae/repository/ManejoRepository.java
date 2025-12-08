package com.example.DicionarioPlantae.repository;

import com.example.DicionarioPlantae.entity.CategoriaTaxonomica;
import com.example.DicionarioPlantae.entity.Manejo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ManejoRepository extends JpaRepository<Manejo, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Manejo c SET c.status = -1 WHERE c.id = :id")
    void apagarManejo (@Param("id")Integer id);

    @Query("SELECT c FROM Manejo c WHERE c.status >= 0")
    List<ManejoResponse> listarManejo();

    @Query("SELECT c FROM Manejo c WHERE c.id = :id")
    Manejo obterManejoPorId (@Param("id")Integer id);


}
