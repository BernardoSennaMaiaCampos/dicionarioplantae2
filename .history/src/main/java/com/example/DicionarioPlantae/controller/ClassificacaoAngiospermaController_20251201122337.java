package com.example.DicionarioPlantae.controller;

import com.example.DicionarioPlantae.dto.request.ClassificacaoAngiospermaDTORequest;
import com.example.DicionarioPlantae.dto.response.ClassificacaoAngiospermaDTOResponse;
import com.example.DicionarioPlantae.entity.ClassificacaoAngiosperma;
import com.example.DicionarioPlantae.service.ClassificacaoAngiospermaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/classificacaoangiosperma")
@Tag(name="classificacaoangiosperma", description = "API para gerenciamento de classificacao de angiospermas")
public class ClassificacaoAngiospermaController {

    private ClassificacaoAngiospermaService classificacaoAngiospermaService;

    public ClassificacaoAngiospermaController(ClassificacaoAngiospermaService classificacaoAngiospermaService){
        this.classificacaoAngiospermaService = classificacaoAngiospermaService;
    }


    @PostMapping("/criar")
    public ResponseEntity<ClassificacaoAngiospermaDTOResponse> criarClassificacaoAngiosperma(@RequestBody ClassificacaoAngiospermaDTORequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.classificacaoAngiospermaService.criarClassificacaoAngiosperma(request));
    }


    @GetMapping("/listar")
    @Operation(summary="Listar classificacao angiospermas", description="Endpoint para listar todas as classificacoes de angiospermas")
    public ResponseEntity<List<ClassificacaoAngiosperma>> listarClassificacaoAngiosperma(){
        return ResponseEntity.ok(ClassificacaoAngiospermaService.listarClassificacaoAngiosperma());
    }


    @GetMapping("/listar/{idClassificacaoAngiosperma}")
    public ResponseEntity<ClassificacaoAngiospermaDTOResponse> listarClassificacaoAngiospermaPorId(@Valid @PathVariable("idClassificacaoAngiosperma") Integer idClassificacaoAngiosperma){
        return ResponseEntity.ok(this.classificacaoAngiospermaService.listarClassificacaoAngiospermaPorId(idClassificacaoAngiosperma));
    }

    @PutMapping("/atualizar/{idClassificacaoAngiosperma}")
    public ResponseEntity<ClassificacaoAngiospermaDTOResponse> atualizarClassificacaoAngiosperma(@Valid @PathVariable("idClassificacaoAngiosperma") Integer idClassificacaoAngiosperma, @RequestBody ClassificacaoAngiospermaDTORequest request){
        return ResponseEntity.ok(this.classificacaoAngiospermaService.atualizarClassificacaoAngiosperma(idClassificacaoAngiosperma, request));
    }

    @DeleteMapping("/apagar/{idClassificacaoAngiosperma}")
    public ResponseEntity<ClassificacaoAngiospermaDTOResponse> apagarClassificacaoAngiosperma(@PathVariable("idClassificacaoAngiosperma") Integer idClassificacaoAngiosperma){
        this.classificacaoAngiospermaService.apagarClassificacaoAngiosperma(idClassificacaoAngiosperma);
        return ResponseEntity.noContent().build();
    }


}
