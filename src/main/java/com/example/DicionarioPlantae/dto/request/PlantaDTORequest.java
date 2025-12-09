package com.example.DicionarioPlantae.dto.request;

public class PlantaDTORequest {

   private String cientifico;
   private String popular;
   private Integer categoriaTaxonomicaId;
   private Integer classificacaoAngiospermaId;
   private Integer origemId;
   private Integer comestivel;
   private Integer status;

    public String getCientifico() {
        return cientifico;
    }

    public void setCientifico(String cientifico) {
        this.cientifico = cientifico;
    }

    public String getPopular() {
        return popular;
    }

    public void setPopular(String popular) {
        this.popular = popular;
    }

    public Integer getCategoriaTaxonomicaId() {
        return categoriaTaxonomicaId;
    }

    public void setCategoriaTaxonomicaId(Integer categoriaTaxonomicaId) {
        this.categoriaTaxonomicaId = categoriaTaxonomicaId;
    }

    public Integer getClassificacaoAngiospermaId() {
        return classificacaoAngiospermaId;
    }

    public void setClassificacaoAngiospermaId(Integer classificacaoAngiospermaId) {
        this.classificacaoAngiospermaId = classificacaoAngiospermaId;
    }

    public Integer getOrigemId() {
        return origemId;
    }

    public void setOrigemId(Integer origemId) {
        this.origemId = origemId;
    }

    public Integer getComestivel() {
        return comestivel;
    }

    public void setComestivel(Integer comestivel) {
        this.comestivel = comestivel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
