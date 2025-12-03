package com.example.DicionarioPlantae.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categoria_taxonomica")
public class CategoriaTaxonomica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categoria_taxonomica_id")
    private int id;

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

    public Set<Planta> getPlantas() {
        return plantas;
    }

    public void setPlantas(Set<Planta> plantas) {
        this.plantas = plantas;
    }

    @Column(name="categoria_taxonomica_nome")
    private String nome;

    @Column(name="categoria_taxonomica_status")
    private int status;

    @OneToMany(mappedBy = "categoriaTaxonomica")
    private Set<Planta> plantas;


}
