package com.example.DicionarioPlantae.service;

import com.example.DicionarioPlantae.entity.Origem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrigemService {

    @Autowired
    public List<Origem> listar() {

        return new ArrayList<>();
    }

    public Origem listarOrigemPorId(Integer IdOrigem) {

        return null;
    }
}
