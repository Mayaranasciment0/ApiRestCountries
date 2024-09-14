package com.example.demo.exception;

public class PaisNotFoundException extends RuntimeException {

    public PaisNotFoundException(Long id) {
        super("País não encontrado pelo ID" + id);
    }

    public PaisNotFoundException(String nome) {
        super("País não encontrado pelo nome" + nome);
    }

}