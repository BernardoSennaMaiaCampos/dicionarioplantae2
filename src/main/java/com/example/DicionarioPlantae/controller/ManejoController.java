package com.example.DicionarioPlantae.controller;


import com.example.DicionarioPlantae.entity.Manejo;
import com.example.DicionarioPlantae.service.ManejoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("api/manejo")
@Tag(name="Manejo", description="API para gerenciamento do manejo" )
public class ManejoController {
    private final ManejoService manejoService;

    public ManejoController(ManejoService manejoService){
        this.manejoService = manejoService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar patrocinador do sistema")
    public ResponseEntity<List<Manejo>> listar(){
        return ResponseEntity.ok(manejoService.listarManejo());
    }

    @GetMapping("/listarPorIdManejo/{IdUser}")
    @Operation(summary = "Listar usuários do sistema pelo id de usuário")
    public ResponseEntity<Manejo> listarPorIdManejo(@PathVariable ("IdManejo") Integer IdManejo){
        Manejo manejo = manejoService.listarManejoPorId(IdManejo);
    if (manejo == null){
        return ResponseEntity.noContent().build();
    }else{
        return ResponseEntity.ok(manejo);
    }

    }


}
