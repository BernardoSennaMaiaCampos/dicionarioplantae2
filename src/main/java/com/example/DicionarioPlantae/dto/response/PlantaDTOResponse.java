package com.example.DicionarioPlantae.dto.response;

public class PlantaDTOResponse {

    private Integer id;
    private String cientifico;
    private String popular;
    private Integer comestivel;
    private Integer status;

    private CategoriaTaxonomicaDTOResponse categoriaTaxonomicaDTOResponse;
    private OrigemDTOResponse origemDTOResponse;
    private ClassificacaoAngiospermaDTOResponse classificacaoAngiospermaDTOResponse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public CategoriaTaxonomicaDTOResponse getCategoriaTaxonomicaDTOResponse() {
        return categoriaTaxonomicaDTOResponse;
    }

    public void setCategoriaTaxonomicaDTOResponse(CategoriaTaxonomicaDTOResponse categoriaTaxonomicaDTOResponse) {
        this.categoriaTaxonomicaDTOResponse = categoriaTaxonomicaDTOResponse;
    }

    public OrigemDTOResponse getOrigemDTOResponse() {
        return origemDTOResponse;
    }

    public void setOrigemDTOResponse(OrigemDTOResponse origemDTOResponse) {
        this.origemDTOResponse = origemDTOResponse;
    }

    public ClassificacaoAngiospermaDTOResponse getClassificacaoAngiospermaDTOResponse() {
        return classificacaoAngiospermaDTOResponse;
    }

    public void setClassificacaoAngiospermaDTOResponse(ClassificacaoAngiospermaDTOResponse classificacaoAngiospermaDTOResponse) {
        this.classificacaoAngiospermaDTOResponse = classificacaoAngiospermaDTOResponse;
    }
}
