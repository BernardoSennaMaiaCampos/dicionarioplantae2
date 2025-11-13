package com.example.DicionarioPlantae.controller;

import com.example.DicionarioPlantae.dto.request.ImagemDTORequest;
import com.example.DicionarioPlantae.dto.request.LocalizacaoDTORequest;
import com.example.DicionarioPlantae.dto.response.LocalizacaoDTOResponse;
import com.example.DicionarioPlantae.service.LocalizacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/localizacao")
@Tag(name="Localizacao", description="API para gerenciamento da localizacao das plantas")
public class LocalizacaoController {

    private LocalizacaoService localizacaoService;

    public LocalizacaoController(LocalizacaoService localizacaoService){
        this.localizacaoService = localizacaoService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar nova localizacao", description = "Endpoint para criar uma nova localizacao")
    public ResponseEntity<LocalizacaoDTOResponse> criarLocalizacao(@Valid @RequestBody LocalizacaoDTORequest localizacao){
        return ResponseEntity.ok(localizacaoService.criarLocalizacao(localizacao));
    }

}
