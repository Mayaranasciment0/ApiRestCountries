package com.example.demo.controller;

import com.example.demo.exception.PaisNotFoundException;
import com.example.demo.model.Pais;
import com.example.demo.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public List<Pais> gettAllPais() {
        return paisService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaiById(@pathVariable Long id) {
        Pais pais = paisService.findById(id);
        if (pais == null) {
            throw new PaisNotFoundException("País não encontrado.");
        }
        return ResponseEntity.ok(pais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable Long id, @RequestBody Pais paisDetails) {
        Pais pais = paisService.findById(id);
        if (pais == null) {
            throw new PaisNotFoundException("País não encontrado.");
        }
        pais.setNome(paisDetails.getNome());
        pais.setCapital(paisDetails.getCapital());
        pais.setRegiao(paisDetails.getRegiao());
        pais.setMoeda(paisDetails.getMoeda());
        Pais updatePais = paisService.savePais(pais);
        return ResponseEntity.ok(updatePais);
    }
}
