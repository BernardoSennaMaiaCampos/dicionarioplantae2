package com.example.DicionarioPlantae.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "classificacao_angiosperma")
public class ClassificacaoAngiosperma {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "classificacao_angiosperma_id")
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Column(name = "classificacao_angiosperma_nome")
  private String nome;

  @Column(name = "classificacao_angiosperma_status")
  private Integer status;

}
