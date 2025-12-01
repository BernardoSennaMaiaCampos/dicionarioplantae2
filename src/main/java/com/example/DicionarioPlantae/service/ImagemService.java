package com.example.DicionarioPlantae.service;

import com.example.DicionarioPlantae.dto.request.ImagemDTORequest;
import com.example.DicionarioPlantae.dto.request.ImagemDTOUpdateRequest;
import com.example.DicionarioPlantae.dto.response.ImagemDTOResponse;
import com.example.DicionarioPlantae.dto.response.ImagemDTOUpdateResponse;
import com.example.DicionarioPlantae.entity.Imagem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImagemService {

    public List<Imagem> listarImagem() {
        // TODO: Implementar lógica de listagem
        return new ArrayList<>();
    }

    public Imagem listarPorIdImagem(Integer IdImagem) {
        // TODO: Implementar lógica de busca por ID
        return null;
    }

    public ImagemDTOUpdateResponse salvar(ImagemDTORequest imagemDTORequest) {
        // TODO: Implementar lógica de salvamento
        return new ImagemDTOUpdateResponse();
    }

    public ImagemDTOResponse atualizarImagem(Integer IdImagem, ImagemDTORequest imagemDTORequest) {
        // TODO: Implementar lógica de atualização
        return new ImagemDTOResponse();
    }

    public ImagemDTOUpdateResponse atualizarImagem(Integer IdImagem, ImagemDTOUpdateRequest imagemStatus) {
        // TODO: Implementar lógica de atualização de status
        return new ImagemDTOUpdateResponse();
    }

    public void apagarImagem(Integer IdImagem) {
        // TODO: Implementar lógica de exclusão
    }
}
