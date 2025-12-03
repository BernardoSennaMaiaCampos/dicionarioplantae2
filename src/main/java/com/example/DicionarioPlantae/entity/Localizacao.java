package com.example.DicionarioPlantae.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.text.DecimalFormat;

@Entity
@Table(name="localizacao")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="localizacao_id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public DecimalFormat getLatitude() {
        return latitude;
    }

    public void setLatitude(DecimalFormat latitude) {
        this.latitude = latitude;
    }

    public DecimalFormat getLongitude() {
        return longitude;
    }

    public void setLongitude(DecimalFormat longitude) {
        this.longitude = longitude;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    @Column(name="localizacao_status")
    private Integer status;

    @Column(name="localizacao_regiao")
    private String regiao;

    @Column(name="localizacao_latitude")
    private DecimalFormat latitude;

    @Column(name="localizacao_longitude")
    private DecimalFormat longitude;

    @ManyToOne
    @JoinColumn(name = "planta_id", nullable = false)
    @JsonIgnore
    private Planta planta;

    @OneToMany (mappedBy = "planta")

}
