package com.example.demo.exception;

public class MoedaNotFoundException extends RuntimeException {

    public MoedaNotFoundException(Long id) {
        super("Moeda não encontrada pela ID: " + id);
    }

    public MoedaNotFoundException(String codigo) {
        super("Moeda não encontrada com o código: " + codigo);
    }
}