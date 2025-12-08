package com.example.DicionarioPlantae.repository;

import com.example.DicionarioPlantae.dto.response.ClassificacaoAngiospermaDTOResponse;
import com.example.DicionarioPlantae.entity.ClassificacaoAngiosperma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClassificacaoAngiospermaRepository extends JpaRepository<ClassificacaoAngiosperma, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE ClassificacaoAngiosperma c SET c.status = -1 WHERE c.id = :id")
    void apagarClassificacaoAngiosperma (@Param("id")Integer id);

    @Query("SELECT c FROM ClassificacaoAngiosperma c WHERE c.status >= 0")
    List<ClassificacaoAngiospermaDTOResponse> listarClassificacaoAngiosperma();

    @Query("SELECT c FROM ClassificacaoAngiosperma c WHERE c.id = :id")
    ClassificacaoAngiosperma obterClassificacaoAngiospermaPorId (@Param("id")Integer id);

}
