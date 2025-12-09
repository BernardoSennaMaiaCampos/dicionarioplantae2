package com.example.DicionarioPlantae.dto.response;

public class LocalizacaoDTOResponse {

    private Integer id;
    private String regiao;
    private Integer latitude;
    private Integer longitude;
    private Integer status;

    public PlantaDTOResponse getPlantaDTOResponse() {
        return plantaDTOResponse;
    }

    public void setPlantaDTOResponse(PlantaDTOResponse plantaDTOResponse) {
        this.plantaDTOResponse = plantaDTOResponse;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    private PlantaDTOResponse plantaDTOResponse;

}
