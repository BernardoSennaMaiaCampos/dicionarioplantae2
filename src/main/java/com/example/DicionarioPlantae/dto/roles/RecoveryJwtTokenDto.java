package com.example.DicionarioPlantae.dto.roles;

import com.example.DicionarioPlantae.dto.response.UsuarioLoginDTOResponse;

public record RecoveryJwtTokenDto (
        UsuarioLoginDTOResponse usuarioLoginResponse,
        String token
){

}

