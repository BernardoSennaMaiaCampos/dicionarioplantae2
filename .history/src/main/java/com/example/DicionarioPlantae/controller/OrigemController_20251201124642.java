package com.example.DicionarioPlantae.controller;


import com.example.DicionarioPlantae.entity.Origem;
import com.example.DicionarioPlantae.service.OrigemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/origem")
@Tag(name="Premio", description = "API para gerenciamento da origem das plantas no sistema")
public class OrigemController {
    private final OrigemService origemService;

    public OrigemController(OrigemService origemService) { this.origemService = origemService;}

    @GetMapping("/listar")
    @Operation(summary = "Listar origens ligadas a plantas no sistema")
    public ResponseEntity<List<Origem>> listar() {return ResponseEntity.ok(origemService.listar());}

    @GetMapping("/listarPorIdOrigem/{IdOrigem}")
    @Operation(summary = "Listar origens de plantas do sistema pelo id da origem")
    public ResponseEntity<Origem> listarPorIdOrigem(@PathVariable("IdOrigem") Integer IdOrigem){
        Origem origem = origemService.listarOrigemPorId(IdOrigem);
        if(origem == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(origem);
        }
    }

}
