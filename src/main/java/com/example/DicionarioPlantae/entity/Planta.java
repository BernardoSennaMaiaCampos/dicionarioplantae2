package com.example.DicionarioPlantae.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;



@Entity
@Table(name = "planta")
public class Planta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="planta_id")
  private Integer id;

  @Column(name="planta_nome_cientifico")
  private String cientifico;

  @Column(name="planta_nome_popular")
  private String popular;

  @Column (name="planta_comestivel")
  private Integer comestivel;

  @Column (name="planta_status")
  private Integer status;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name ="categoria_taxonomica_id", nullable = false)
  private Categoria_taxonomica categoria_taxonomica;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "origem_id", nullable = false)
  private Origem origem;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "classificacao_angiosperma", nullable = false)
  private Classificao_angiosperma Classificacao_angiosperma;

  @OneToMany (mappedBy = "planta")

  public Categoria_taxonomica getCategoria_taxonomica() {
    return categoria_taxonomica;
  }

  public void setCategoria_taxonomica(Categoria_taxonomica categoria_taxonomica) {
    this.categoria_taxonomica = categoria_taxonomica;
  }

  public Classificao_angiosperma getClassificacao_angiosperma() {
    return Classificacao_angiosperma;
  }

  public void setClassificacao_angiosperma(Classificao_angiosperma classificacao_angiosperma) {
    Classificacao_angiosperma = classificacao_angiosperma;
  }


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


  public Origem getOrigem() {
    return origem;
  }

  public void setOrigem(Origem origem) {
    this.origem = origem;
  }









}
