package com.example.DicionarioPlantae.repository;

import com.example.DicionarioPlantae.dto.response.PlantaDTOResponse;
import com.example.DicionarioPlantae.entity.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Planta c SET c.status = -1 WHERE c.id = :id")
    void apagarPlanta (@Param("id")Integer id);

    @Query("SELECT c FROM Planta c WHERE c.status >= 0")
    List<PlantaDTOResponse> listarPlanta();

    @Query("SELECT c FROM Planta c WHERE c.id = :id")
    Planta obterPlantaPorId (@Param("id")Integer id);

}
