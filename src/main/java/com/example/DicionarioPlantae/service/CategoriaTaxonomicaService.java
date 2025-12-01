package com.example.DicionarioPlantae.service;

import com.example.DicionarioPlantae.dto.request.CategoriaTaxonomicaDTORequest;
import com.example.DicionarioPlantae.dto.response.CategoriaTaxonomicaDTOResponse;
import com.example.DicionarioPlantae.entity.CategoriaTaxonomica;
import com.example.DicionarioPlantae.repository.CategoriaTaxonomicaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaTaxonomicaService {

    @Autowired
    private CategoriaTaxonomicaRepository categoriaTaxonomicaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CategoriaTaxonomica> listarCategoriaTaxonomica() {
        return categoriaTaxonomicaRepository.findAll();
    }

    public CategoriaTaxonomica listarPorCategoriaTaxonomicaId(Integer categoriaTaxonomicaId) {
        return categoriaTaxonomicaRepository.findById(categoriaTaxonomicaId).orElse(null);
    }

    public CategoriaTaxonomicaDTOResponse salvar(CategoriaTaxonomicaDTORequest categoriaTaxonomicaDTORequest) {
        CategoriaTaxonomica categoriaTaxonomica = modelMapper.map(categoriaTaxonomicaDTORequest, CategoriaTaxonomica.class);
        CategoriaTaxonomica savedCategoria = categoriaTaxonomicaRepository.save(categoriaTaxonomica);
        return modelMapper.map(savedCategoria, CategoriaTaxonomicaDTOResponse.class);
    }

    public CategoriaTaxonomicaDTOResponse atualizarCategoriaTaxonomica(Integer idCategoriaTaxonomica, CategoriaTaxonomicaDTORequest request) {
        CategoriaTaxonomica categoriaTaxonomica = categoriaTaxonomicaRepository.findById(idCategoriaTaxonomica)
                .orElseThrow(() -> new RuntimeException("CategoriaTaxonomica not found"));
        modelMapper.map(request, categoriaTaxonomica);
        CategoriaTaxonomica updatedCategoria = categoriaTaxonomicaRepository.save(categoriaTaxonomica);
        return modelMapper.map(updatedCategoria, CategoriaTaxonomicaDTOResponse.class);
    }

    public void apagarCategoriaTaxonomica(Integer idCategoriaTaxonomica) {
        categoriaTaxonomicaRepository.deleteById(idCategoriaTaxonomica);
    }
}
