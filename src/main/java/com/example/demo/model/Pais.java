package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.ToString;

@Entity
@ToString
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String capital;
    private String regiao;

    public Pais(long id, String nome, String capital, String regiao) {
        this.id = id;
        this.nome = nome;
        this.capital = capital;
        this.regiao = regiao;
    }

    // relacionamento 1:1 com Moeda
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "moeda_id", referencedColumnName = "id")
    private Moeda moeda;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

}
