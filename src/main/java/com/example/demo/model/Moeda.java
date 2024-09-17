package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Moeda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String simbolo;
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    public Moeda() {
    }

    public Moeda(String nome, String simbolo, String codigo, Pais pais) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.codigo = codigo;
        this.pais = pais;
    }
}