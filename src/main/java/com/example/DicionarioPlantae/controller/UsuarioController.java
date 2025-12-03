package com.example.DicionarioPlantae.controller;

import com.example.DicionarioPlantae.dto.request.UsuarioRequest;
import com.example.DicionarioPlantae.dto.response.UsuarioResponse;
import com.example.DicionarioPlantae.entity.Usuario;
import com.example.DicionarioPlantae.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@Tag(name="Usuario", description = "API para gerenciamento de usuários do sistema")
public class UsuarioController {

  private final UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping("/listar")
  @Operation(summary = "Listar usuarios do sistema")
  public ResponseEntity<List<Usuario>> listar(){
    return ResponseEntity.ok(usuarioService.listarUsuario());
  }

  @GetMapping("/listarPorIdUsuario/{idUsuario}")
  @Operation(summary = "Listar usuarios do sistema pelo id do usuário")
  public ResponseEntity<Usuario> listarPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
    Usuario usuario = usuarioService.listarUsuarioPorId(idUsuario);
    if (usuario == null) {
      return ResponseEntity.noContent().build();
    }else{
      return ResponseEntity.ok(usuario);
    }
  }

  @PostMapping("/criar")
  @Operation(summary = "Criar um novo usuario")
  public ResponseEntity<UsuarioResponse> criar(@Valid @RequestBody UsuarioRequest usuarioRequest){
    return ResponseEntity.ok(usuarioService.salvar(usuarioRequest));
  }

  @PutMapping("/atualizar/{id}")
  @Operation(summary = "Atualizar todos os dados um usuario")
  public ResponseEntity<UsuarioResponse> atualizar(
      @Valid @PathVariable("idUsuario") Integer idUsuario,
      @RequestBody UsuarioRequest usuarioRequest){
    return ResponseEntity.ok(usuarioService.atualizar(idUsuario, usuarioRequest));
  }

  @DeleteMapping("/apagar/{idUsuario}")
  @Operation(summary = "Apagar usuario pelo idUsuario")
  public ResponseEntity<UsuarioResponse> apagar(@PathVariable("idUsuario") Integer idUsuario){
    usuarioService.apagar(idUsuario);
    return ResponseEntity.noContent().build();
  }
}

