package com.example.DicionarioPlantae.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Manejo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="manejo_id")
    private int id;

    @Column(name="manejo_descricao")
    private String descricao;

    @Column(name="manejo_status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "planta_id", nullable = false)
    @JsonIgnore
    private Planta planta;

    @OneToMany (mappedBy = "manejo")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }


}
