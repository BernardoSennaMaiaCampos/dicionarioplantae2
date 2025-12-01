package com.example.DicionarioPlantae.service;

import com.example.DicionarioPlantae.entity.Manejo;
import com.example.DicionarioPlantae.repository.ManejoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManejoService {

    @Autowired
    private ManejoRepository manejoRepository;

    public List<Manejo> listarManejo() {
        return manejoRepository.findAll();
    }

    public Manejo listarManejoPorId(Integer idManejo) {
        return manejoRepository.findById(idManejo).orElse(null);
    }
}
