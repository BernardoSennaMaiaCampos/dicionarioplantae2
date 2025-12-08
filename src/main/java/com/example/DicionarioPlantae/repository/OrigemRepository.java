package com.example.DicionarioPlantae.repository;

import com.example.DicionarioPlantae.dto.response.OrigemDTOResponse;
import com.example.DicionarioPlantae.entity.Origem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrigemRepository extends JpaRepository<Origem, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Origem c SET c.status = -1 WHERE c.id = :id")
    void apagarOrigem(@Param("id")Integer id);

    @Query("SELECT c FROM Origem c WHERE c.status >= 0")
    List<OrigemDTOResponse> listarOrigem();

    @Query("SELECT c FROM Origem c WHERE c.id = :id")
    Origem obterOrigemPorId (@Param("id")Integer id);

}
