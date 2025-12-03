package com.example.DicionarioPlantae.dto.roles;

import com.example.DicionarioPlantae.entity.Roles.Role;

import java.util.List;

public record RecoveryUserDto (
        Long id,
        String email,
        List<Role> roles
){

}

