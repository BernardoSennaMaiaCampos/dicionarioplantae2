package com.example.DicionarioPlantae.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Planta {

  @Column(name="planta_id")
  private Integer id;

  @Column(name="planta_nome_cientifico")
  private String planta_nome_cientifico;

  @Column(name="planta_nome_popular")
  private String planta_nome_popular;

  @Column (name="planta_comestivel")
  private Integer planta_comestivel;

  @Column (name="planta_status")
  private Integer planta_status;


}
