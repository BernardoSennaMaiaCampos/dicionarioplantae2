package com.example.DicionarioPlantae.entity;

import jakarta.persistence.*;

@Entity
public class Origem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="origem_id")
  private Integer id;

  @Column(name="origem_tipo")
  private String tipo;
  @Column(name="origem_status")
  private Integer status;

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

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
