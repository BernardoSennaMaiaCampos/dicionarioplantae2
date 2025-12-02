package com.example.DicionarioPlantae.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Imagem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="imagem_id")
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getImagem_tipo() {
    return imagem_tipo;
  }

  public void setImagem_tipo(String imagem_tipo) {
    this.imagem_tipo = imagem_tipo;
  }

  public String getImagem_url() {
    return imagem_url;
  }

  public void setImagem_url(String imagem_url) {
    this.imagem_url = imagem_url;
  }

  public Integer getImagem_status() {
    return imagem_status;
  }

  public void setImagem_status(Integer imagem_status) {
    this.imagem_status = imagem_status;
  }

  public Planta getPlanta() {
    return planta;
  }

  public void setPlanta(Planta planta) {
    this.planta = planta;
  }

  @Column(name="imagem_tipo")
  private String imagem_tipo;

  @Column(name="imagem_url")
  private String imagem_url;

  @Column(name="imagem_status")
  private Integer imagem_status;

  @ManyToOne
  @JoinColumn(name = "planta_id", nullable = false)
  @JsonIgnore
  private Planta planta;



}
