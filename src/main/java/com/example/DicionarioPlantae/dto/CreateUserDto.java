package com.example.DicionarioPlantae.dto;

import com.example.DicionarioPlantae.entity.RoleName;

public record CreateUserDto (

    String email,
    String password,
    RoleName role

){

}
