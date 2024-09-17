package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String capital;
    private String regiao;

    @OneToOne
    @JoinColumn(name = "moeda_id", referencedColumnName = "id")
    private Moeda moeda;

    public Pais() {
    }

    public Pais(String nome, String capital, String regiao, Moeda moeda) {
        this.nome = nome;
        this.capital = capital;
        this.regiao = regiao;
        this.moeda = moeda;
    }
}