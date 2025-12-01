package com.example.DicionarioPlantae.controller;

import com.example.DicionarioPlantae.service.PlantaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/planta")
@Tag(name="Planta", description = "API para gerenciamento de plantas")
public class PlantaController {

    private PlantaService plantaService;

    public PlantaController(PlantaService plantaService){this.plantaService = plantaService;}

    @GetMapping("/listar")
    @Operation(summary="Listar plantas", description = "Endpoint para listar todas as plantas")
    public ResponseEntity<List<Planta>> listarPlantas(){
        return ResponseEntity.ok(plantaService.listarPlanta());
    }

}
