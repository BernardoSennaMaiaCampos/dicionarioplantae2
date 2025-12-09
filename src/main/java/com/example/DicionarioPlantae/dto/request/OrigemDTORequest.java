package com.example.DicionarioPlantae.dto.request;

public class OrigemDTORequest {

    private String tipo;
    private Integer status;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
