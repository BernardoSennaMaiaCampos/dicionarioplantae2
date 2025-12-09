package com.example.DicionarioPlantae.dto.response;

public class ManejoResponse {

    private Integer id;
    private String descricao;
    private Integer status;
    private PlantaDTOResponse plantaDTOResponse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public PlantaDTOResponse getPlantaDTOResponse() {
        return plantaDTOResponse;
    }

    public void setPlantaDTOResponse(PlantaDTOResponse plantaDTOResponse) {
        this.plantaDTOResponse = plantaDTOResponse;
    }
}
