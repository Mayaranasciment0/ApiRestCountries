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
    public List<Pais> getAllPaises() {
        return paisService.getAllPais();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable Long id) {
        Optional<Pais> pais = paisService.getPaisById(id);
        return pais.map(ResponseEntity::ok)
                   .orElseThrow(() -> new PaisNotFoundException(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable Long id, @RequestBody Pais paisDetails) {
        Pais paisAtualizado = paisService.updatePais(id, paisDetails);
        return ResponseEntity.ok(paisAtualizado);
    }
}
