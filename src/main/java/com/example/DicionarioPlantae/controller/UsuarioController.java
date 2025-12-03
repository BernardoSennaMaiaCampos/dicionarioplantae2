package com.example.DicionarioPlantae.controller;

import com.example.DicionarioPlantae.dto.request.UserDTORequest;
import com.example.DicionarioPlantae.dto.response.UserDTOResponse;
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

  @GetMapping("/listarPorIdUser/{idUser}")
  @Operation(summary = "Listar usuarios do sistema pelo id do usuário")
  public ResponseEntity<Usuario> listarPorIdUsuario(@PathVariable("idUsuario") Integer idUser){
    Usuario usuario = usuarioService.listarUsuarioPorId(idUsuario);
    if (usuario == null) {
      return ResponseEntity.noContent().build();
    }else{
      return ResponseEntity.ok(usuario);
    }
  }

  @PostMapping("/criar")
  @Operation(summary = "Criar um novo usuario")
  public ResponseEntity<UserDTOResponse> criar(@Valid @RequestBody UserDTORequest userDtoRequest){
    return ResponseEntity.ok(usuarioService.salvar(userDtoRequest));
  }

  @PutMapping("/atualizar/{idUser}")
  @Operation(summary = "Atualizar todos os dados um usuario")
  public ResponseEntity<UserDTOResponse> atualizar(
      @Valid @PathVariable("idUser") Integer idUser,
      @RequestBody UserDTORequest userDtoRequest){
    return ResponseEntity.ok(usuarioService.atualizar(idUser, userDtoRequest));
  }

  @DeleteMapping("/apagar/{idUser}")
  @Operation(summary = "Apagar usuario pelo idUsuario")
  public ResponseEntity<UserDTOResponse> apagar(@PathVariable("idUser") Integer idUser){
    usuarioService.apagar(idUser);
    return ResponseEntity.noContent().build();
  }
}

