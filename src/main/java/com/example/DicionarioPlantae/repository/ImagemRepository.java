package com.example.DicionarioPlantae.repository;

import com.example.DicionarioPlantae.dto.response.ImagemDTOResponse;
import com.example.DicionarioPlantae.entity.ClassificacaoAngiosperma;
import com.example.DicionarioPlantae.entity.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Imagem c SET c.status = -1 WHERE c.id = :id")
    void apagarImagem (@Param("id")Integer id);

    @Query("SELECT c FROM Imagem c WHERE c.status >= 0")
    List<ImagemDTOResponse> listarImagem();

    @Query("SELECT c FROM Imagem c WHERE c.id = :id")
    Imagem obterImagemPorId (@Param("id")Integer id);

}
