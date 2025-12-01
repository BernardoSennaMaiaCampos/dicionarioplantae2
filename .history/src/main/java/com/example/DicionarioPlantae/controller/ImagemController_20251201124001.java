package com.example.DicionarioPlantae.controller;

import com.example.DicionarioPlantae.dto.request.ImagemDTORequest;
import com.example.DicionarioPlantae.dto.request.ImagemDTOUpdateRequest;
import com.example.DicionarioPlantae.dto.response.ImagemDTOResponse;
import com.example.DicionarioPlantae.dto.response.ImagemDTOUpdateResponse;
import com.example.DicionarioPlantae.entity.Imagem;
import com.example.DicionarioPlantae.service.ImagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/imagem")
@Tag(name="Imagem", description="API para imagem das plantas")
public class ImagemController {

    private ImagemService imagemService;

    public ImagemController(ImagemService imagemService){
        this.imagemService = imagemService;
    }

    @GetMapping("/listar")
    @Operation(summary="Listar imagem", description = "Endpoint para listar as imagens das plantas")
    public ResponseEntity<List<Imagem>> listarImagem(){
        return ResponseEntity.ok(imagemService.listarImagem());
    }

    @GetMapping("/listarPorIdImagem/{IdImagem}")
    @Operation(summary="Listar imagem pelo id de imagem", description = "Endpoint para obter imagem pelo id de imagem")
    public ResponseEntity<Imagem> listarPorImagemId(@PathVariable("IdImagem") Integer IdImagem){
        Imagem imagem = imagemService.listarPorIdImagem(IdImagem);
        if(imagem == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(imagem);
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar nova imagem", description = "Endpoint para criar um novo registro de imagem de planta")
    public ResponseEntity<ImagemDTOUpdateResponse> atualizarStatusImagem(@Valid @RequestBody ImagemDTORequest imagemDTORequest){
        return ResponseEntity.ok(imagemService.salvar(imagemDTORequest));
    }

    @PutMapping("/atualizar/{IdImagem}")
    @Operation(summary = "Atualizar todos os dados da imagem", description="Endpoint para atualizar a imagem da planta")
    public ResponseEntity<ImagemDTOResponse>atualizarImagem(@Valid @PathVariable("IdImagem") Integer IdImagem, @RequestBody ImagemDTORequest imagemDTORequest){
        return ResponseEntity.ok(imagemService.atualizarImagem(IdImagem, imagemDTORequest));
    }

    @PatchMapping("/atualizarStatus/{IdImagem}")
    @Operation(summary = "Atualizar o campo status", description = "Atualiza o status da imagem")
    public ResponseEntity<ImagemDTOUpdateResponse> atualizarStatusImagem(@PathVariable("IdImagem") Integer IdImagem, @RequestBody ImagemDTOUpdateRequest imagemStatus){
        return ResponseEntity.ok(imagemService.atualizarImagem(IdImagem, imagemStatus));
    }

    @DeleteMapping("/apagar/IdImagem")
    @Operation(summary="Deletar uma imagem", description="Deleta uma imagem")
    public ResponseEntity deletarImagem(@PathVariable("IdImagem") Integer IdImagem){
        this.imagemService.apagarUsuario(IdImagem);
        return ResponseEntity.noContent().build;
    }

}
