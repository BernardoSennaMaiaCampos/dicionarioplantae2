package com.example.DicionarioPlantae.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "imagem")
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

  public Planta getPlanta() {
    return planta;
  }

  public void setPlanta(Planta planta) {
    this.planta = planta;
  }

  @Column(name="imagem_tipo")
  private String tipo;

  @Column(name="imagem_url")
  private String url;

  @Column(name="imagem_status")
  private Integer status;

  @ManyToOne
  @JoinColumn(name = "planta_id", nullable = false)
  @JsonIgnore
  private Planta planta;



}
