package com.example.demo.dto;

public class paisDTO {
    private String nome;
    private String capital;
    private String regiao;
    private String moedaCodigo;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCapital() { return capital; }
    public void setCapital(String capital) { this.capital = capital; }

    public String getRegiao() { return regiao; }
    public void setRegiao(String regiao) { this.regiao = regiao; }

    public String getMoedaCodigo() { return moedaCodigo; }
    public void setMoedaCodigo(String moedaCodigo) { this.moedaCodigo = moedaCodigo; }
}