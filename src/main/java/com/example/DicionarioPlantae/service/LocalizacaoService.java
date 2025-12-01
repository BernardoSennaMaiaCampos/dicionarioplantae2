package com.example.DicionarioPlantae.service;

import com.example.DicionarioPlantae.dto.request.LocalizacaoDTORequest;
import com.example.DicionarioPlantae.dto.response.LocalizacaoDTOResponse;
import com.example.DicionarioPlantae.entity.Localizacao;
import com.example.DicionarioPlantae.repository.LocalizacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public LocalizacaoDTOResponse criarLocalizacao(LocalizacaoDTORequest localizacaoDTORequest) {
        Localizacao localizacao = modelMapper.map(localizacaoDTORequest, Localizacao.class);
        Localizacao savedLocalizacao = localizacaoRepository.save(localizacao);
        return modelMapper.map(savedLocalizacao, LocalizacaoDTOResponse.class);
    }
}
