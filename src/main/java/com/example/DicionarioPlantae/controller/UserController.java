package com.example.DicionarioPlantae.controller;

import com.example.DicionarioPlantae.dto.CreateUserDto;
import com.example.DicionarioPlantae.dto.LoginUserDto;
import com.example.DicionarioPlantae.dto.RecoveryJwtTokenDto;
import com.example.DicionarioPlantae.dto.request.UserDTORequest;
import com.example.DicionarioPlantae.dto.response.UserDTOResponse;
import com.example.DicionarioPlantae.entity.User;
import com.example.DicionarioPlantae.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@Tag(name="User", description = "API para gerenciamento de usuários do sistema")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar usuarios do sistema")
    public ResponseEntity<List<User>> listar(){
        return ResponseEntity.ok(userService.listarUser());
    }

    @GetMapping("/listarPorIdUser/{idUser}")
    @Operation(summary = "Listar usuarios do sistema pelo id do usuário")
    public ResponseEntity<User> listarPorIdUser(@PathVariable("idUser") Integer idUser){
        User user = userService.listarUserPorId(idUser);
        if (user == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(user);
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar um novo usuario")
    public ResponseEntity<UserDTOResponse> criar(@Valid @RequestBody UserDTORequest userDtoRequest){
        return ResponseEntity.ok(userService.salvar(userDtoRequest));
    }

    @PutMapping("/atualizar/{idUser}")
    @Operation(summary = "Atualizar todos os dados um usuario")
    public ResponseEntity<UserDTOResponse> atualizar(
            @Valid @PathVariable("idUser") Integer idUser,
            @RequestBody UserDTORequest userDtoRequest){
        return ResponseEntity.ok(userService.atualizar(idUser, userDtoRequest));
    }

    @DeleteMapping("/apagar/{idUser}")
    @Operation(summary = "Apagar usuario pelo idUsuario")
    public ResponseEntity<UserDTOResponse> apagar(@PathVariable("idUser") Integer idUser){
        userService.apagar(idUser);
        return ResponseEntity.noContent().build();
    }
}
