package com.example.DicionarioPlantae.dto.response;

public class ImagemDTOResponse {

    private Integer id;
    private String tipo;
    private String url;
    private Integer status;
    private PlantaDTOResponse plantaDTOResponse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
