package com.example.DicionarioPlantae.repository;

import com.example.DicionarioPlantae.dto.response.LocalizacaoDTOResponse;
import com.example.DicionarioPlantae.entity.Imagem;
import com.example.DicionarioPlantae.entity.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Localizacao c SET c.status = -1 WHERE c.id = :id")
    void apagarLocalizacao (@Param("id")Integer id);

    @Query("SELECT c FROM Localizacao c WHERE c.status >= 0")
    List<LocalizacaoDTOResponse> listarLocalizacao();

    @Query("SELECT c FROM Localizacao c WHERE c.id = :id")
    Localizacao obterLocalizacaoPorId (@Param("id")Integer id);

}
