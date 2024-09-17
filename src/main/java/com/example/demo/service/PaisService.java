package com.example.demo.service;

import com.example.demo.exception.PaisNotFoundException;
import com.example.demo.model.Pais;
import com.example.demo.repository.MoedaRepository;
import com.example.demo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private MoedaRepository moedaRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_COUNTRIES_API_URL = "https://restcountries.com/v3.1/all";

    public Pais savePais(Pais pais) {
        return paisRepository.save(pais);
    }

    public Optional<Pais> getPaisById(Long id) {
        return paisRepository.findById(id);
    }

    public Optional<Pais> getPaisByName(String nome) {
        return paisRepository.findByNome(nome);
    }

    public Pais updatePais(Long id, Pais paisAtualizado) {
        return paisRepository.findById(id)
                .map(pais -> {
                    pais.setNome(paisAtualizado.getNome());
                    pais.setCapital(paisAtualizado.getCapital());
                    pais.setRegiao(paisAtualizado.getRegiao());
                    return paisRepository.save(pais);
                })
                .orElseThrow(() -> new PaisNotFoundException(id));
    }

    public void deletePais(Long id) {
        if (paisRepository.existsById(id)) {
            paisRepository.deleteById(id);
        } else {
            throw new PaisNotFoundException(id);
        }
    }

    public List<Pais> getAllPais() {
        return paisRepository.findAll();
    }
}