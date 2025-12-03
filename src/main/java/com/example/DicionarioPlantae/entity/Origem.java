package com.example.DicionarioPlantae.entity;

import jakarta.persistence.*;

@Entity
public class Origem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="origem_id")
  private Integer id;

  @Column(name="origem_tipo")
  private String origem_tipo;

  @Column(name="origem_status")
  private Integer origem_status;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOrigem_tipo() {
    return origem_tipo;
  }

  public void setOrigem_tipo(String origem_tipo) {
    this.origem_tipo = origem_tipo;
  }

  public Integer getOrigem_status() {
    return origem_status;
  }

  public void setOrigem_status(Integer origem_status) {
    this.origem_status = origem_status;
  }




}
