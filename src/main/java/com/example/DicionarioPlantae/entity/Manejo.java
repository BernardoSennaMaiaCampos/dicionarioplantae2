package com.example.DicionarioPlantae.entity;

import jakarta.persistence.*;

@Entity
public class Manejo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="manejo_id")
    private int id;

    @Column(name="manejo_nome")
    private String nome;

    @Column(name="manejo_status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
