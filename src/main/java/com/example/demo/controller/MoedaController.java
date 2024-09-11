package main.java.com.example.demo.controller;

import main.java.com.exemple.demo.exception.MoedaNotFoundException;
import main.java.com.example.demo.model.Moeda;
import main.java.com.example.demo.service.MoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/moedas")
public class MoedaController {

    @Autowired
    private MoedaService moedaService;

    @GetMapping
    public ResponseEntity<List<Moeda>> getAllMoedas() {
        return ResponseEntity.ok(moedaService.getAllMoedas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moeda> getMoedaById(@PathVariable Long id) {
        Optional<Moeda> moeda = moedaService.getMoedaById(id);
        return ResponseEntity.ok(moeda.get());
    }

    @PostMapping
    public ResponseEntity<Moeda> createMoeda(@RequestBody Moeda moeda) {
        Moeda novaMoeda = moedaService.saveMoeda(moeda);
        return ResponseEntity.ok(novaMoeda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Moeda> updateMoeda(@PathVariable Long id, @RequestBody Moeda moeda) {
        Moeda moedaAtualizada = moedaService.updateMoeda(id, moeda);
        return ResponseEntity.ok(moedaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMoeda(@PathVariable Long id) {
        moedaService.deleteMoeda(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MoedaNotFoundException.class)
    public ResponseEntity<String> handleMoedaNotFoundException(MoedaNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
