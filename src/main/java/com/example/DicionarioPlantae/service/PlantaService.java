package com.example.DicionarioPlantae.service;

import com.example.DicionarioPlantae.entity.Planta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantaService {

    @Autowired
    public List<Planta> listarPlanta() {

        return new ArrayList<>();
    }
}
