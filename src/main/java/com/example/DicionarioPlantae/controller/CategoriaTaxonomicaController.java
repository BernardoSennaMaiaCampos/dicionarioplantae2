package com.example.DicionarioPlantae.controller;

import com.example.DicionarioPlantae.dto.request.CategoriaTaxonomicaDTORequest;
import com.example.DicionarioPlantae.dto.response.CategoriaTaxonomicaDTOResponse;
import com.example.DicionarioPlantae.entity.CategoriaTaxonomica;
import com.example.DicionarioPlantae.service.CategoriaTaxonomicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria_taxonomica")
@Tag(name="categoria_taxonomica", description="API para gerenciamento de categoria taxonomica de plantas")
public class CategoriaTaxonomicaController {

    private CategoriaTaxonomicaService categoriaTaxonomicaService;

    public CategoriaTaxonomicaController(CategoriaTaxonomicaService categoriaTaxonomicaService) {this.categoriaTaxonomicaService = categoriaTaxonomicaService;}

    @GetMapping("/listar")
    @Operation(summary="Listar categorias", description = "Endpoint para listar todos os CategoriasTaxonomicas")
    public ResponseEntity<List<CategoriaTaxonomica>> listarCategoriaTaxonomica(){
        return ResponseEntity.ok(categoriaTaxonomicaService.listarCategoriaTaxonomica());
    }


    @GetMapping("/listar/{categoriaTaxonomicaId}")
    @Operation(summary="", description="")
    public ResponseEntity<CategoriaTaxonomica> listarPorCategoriaTaxonomicaId(@PathVariable("categoriaTaxonomicaId") Integer categoriaTaxonomicaId) {
        CategoriaTaxonomica categoriaTaxonomica = categoriaTaxonomicaService.listarPorCategoriaTaxonomicaId(categoriaTaxonomicaId);
        if (categoriaTaxonomica == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(categoriaTaxonomica);
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar uma categoria")
    public ResponseEntity<CategoriaTaxonomicaDTOResponse> criarCategoriaTaxonomica(@Valid @RequestBody CategoriaTaxonomicaDTORequest categoriaTaxonomicaDTORequest){
        return ResponseEntity.ok(categoriaTaxonomicaService.salvar(categoriaTaxonomicaDTORequest));
    }

    @PutMapping("/atualizar/{IdCategoriaTaxonomica}")
    @Operation(summary = "Atualizar uma categoria")
    public ResponseEntity<CategoriaTaxonomicaDTOResponse> atualizarCategoriaTaxonomica(@PathVariable("IdCategoriaTaxonomica") Integer idCategoriaTaxonomica, @RequestBody CategoriaTaxonomicaDTORequest request){
        return ResponseEntity.ok(this.categoriaTaxonomicaService.atualizarCategoriaTaxonomica(idCategoriaTaxonomica, request));
    }

    @DeleteMapping("/apagar/{IdCategoriaTaxonomica}")
    @Operation(summary = "Apgar uma categoria")
    public ResponseEntity<Void> apagarCategoriaTaxonomica(@PathVariable("IdCategoriaTaxonomica") Integer IdCategoriaTaxonomica){
        this.categoriaTaxonomicaService.apagarCategoriaTaxonomica(IdCategoriaTaxonomica);
        return ResponseEntity.noContent().build();
    }

}



