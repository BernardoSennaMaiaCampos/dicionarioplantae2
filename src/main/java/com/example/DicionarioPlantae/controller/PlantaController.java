package com.example.DicionarioPlantae.controller;

import com.example.DicionarioPlantae.dto.request.PlantaDTORequest;

import com.example.DicionarioPlantae.entity.Planta;
import com.example.DicionarioPlantae.service.PlantaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/planta")
@Tag(name = "Planta", description = "API para gerenciamento de plantas")
public class PlantaController {

    private PlantaService plantaService;

    public PlantaController(PlantaService plantaService) {
        this.plantaService = plantaService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar plantas", description = "Endpoint para listar todas as plantas")
    public ResponseEntity<List<Planta>> listarPlantas() {
        return ResponseEntity.ok(plantaService.listarPlanta());
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar planta", description = "Endpoint para criar uma nova planta")
    public ResponseEntity<Planta> criarPlanta(@RequestBody PlantaDTORequest plantaDTORequest) {
        return ResponseEntity.ok(plantaService.criarPlanta(plantaDTORequest));
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizar planta", description = "Endpoint para atualizar uma planta existente")
    public ResponseEntity<Planta> atualizarPlanta(@PathVariable Integer id,
            @RequestBody PlantaDTORequest plantaDTORequest) {
        return ResponseEntity.ok(plantaService.atualizarPlanta(id, plantaDTORequest));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter planta por ID", description = "Endpoint para obter detalhes de uma planta pelo ID")
    public ResponseEntity<Planta> obterPlantaPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(plantaService.obterPorId(id));
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar plantas por nome", description = "Endpoint para buscar plantas por nome popular")
    public ResponseEntity<List<Planta>> buscarPlantas(@RequestParam String nome) {
        return ResponseEntity.ok(plantaService.buscarPorNome(nome));
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar planta", description = "Endpoint para deletar (soft delete) uma planta pelo ID")
    public ResponseEntity<Void> deletarPlanta(@PathVariable Integer id) {
        plantaService.deletarPlanta(id);
        return ResponseEntity.noContent().build();
    }

}
