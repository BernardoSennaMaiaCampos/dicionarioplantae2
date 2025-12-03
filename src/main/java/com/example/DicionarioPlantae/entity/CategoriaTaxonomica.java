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

    @Column(name="categoria_taxonomica_nome")
    private String nome;

    @Column(name="categoria_taxonomica_status")
    private int status;

    @OneToMany(mappedBy = "categoriaTaxonomica")
    private Set<Planta> plantas;


}
