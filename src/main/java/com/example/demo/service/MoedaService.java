package com.example.demo.service;

import com.example.demo.model.Moeda;
import com.example.demo.exception.MoedaNotFoundException;
import com.example.demo.repository.MoedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MoedaService {

    @Autowired
    private MoedaRepository moedaRepository;

    public List<Moeda> getAllMoedas() {
        return moedaRepository.findAll();
    }

    public Optional<Moeda> getMoedaById(Long id) {
        return moedaRepository.findById(id);
    }

    public Moeda saveMoeda(Moeda moeda) {
        return moedaRepository.save(moeda);
    }

    public Moeda updateMoeda(Long id, Moeda moedaAtualizada) {
        return moedaRepository.findById(id)
                .map(moeda -> {
                    moeda.setNome(moedaAtualizada.getNome());
                    moeda.setSimbolo(moedaAtualizada.getSimbolo());
                    moeda.setCodigo(moedaAtualizada.getCodigo());
                    moeda.setPais(moedaAtualizada.getPais());
                    return moedaRepository.save(moeda);
                }).orElseThrow(() -> new MoedaNotFoundException(id));
    }

    public void deleteMoeda(Long id) {
        if (moedaRepository.existsById(id)) {
            moedaRepository.deleteById(id);
        } else {
            throw new MoedaNotFoundException(id);
        }
    }

    public Optional<Moeda> findByCodigo(String codigo) {
        return moedaRepository.findByCodigo(codigo);
    }
}