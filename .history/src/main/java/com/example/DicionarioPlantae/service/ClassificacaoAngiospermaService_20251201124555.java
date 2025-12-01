package com.example.DicionarioPlantae.service;

import com.example.DicionarioPlantae.dto.request.ClassificacaoAngiospermaDTORequest;
import com.example.DicionarioPlantae.dto.response.ClassificacaoAngiospermaDTOResponse;
import com.example.DicionarioPlantae.entity.ClassificacaoAngiosperma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassificacaoAngiospermaService {

    public ClassificacaoAngiospermaDTOResponse criarClassificacaoAngiosperma(ClassificacaoAngiospermaDTORequest request) {
        // TODO: Implementar lógica de criação
        return new ClassificacaoAngiospermaDTOResponse();
    }

    public List<ClassificacaoAngiosperma> listarClassificacaoAngiosperma() {
        // TODO: Implementar lógica de listagem
        return new ArrayList<>();
    }

    public ClassificacaoAngiospermaDTOResponse listarClassificacaoAngiospermaPorId(Integer idClassificacaoAngiosperma) {
        // TODO: Implementar lógica de busca por ID
        return new ClassificacaoAngiospermaDTOResponse();
    }

    public ClassificacaoAngiospermaDTOResponse atualizarClassificacaoAngiosperma(Integer idClassificacaoAngiosperma, ClassificacaoAngiospermaDTORequest request) {
        // TODO: Implementar lógica de atualização
        return new ClassificacaoAngiospermaDTOResponse();
    }

    public void apagarClassificacaoAngiosperma(Integer idClassificacaoAngiosperma) {
        // TODO: Implementar lógica de exclusão
    }
}
