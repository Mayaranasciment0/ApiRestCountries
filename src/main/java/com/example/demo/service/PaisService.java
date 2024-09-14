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

    //URL da API
    private static final String REST_COUNTRIES_API_URL = "https://restcountries.com/v3.1/all";


    // salvar país
    public Pais savePais(Pais pais) {
        return paisRepository.save(pais);
    }

    // pegar país por ID
    public Optional<Pais> getPaisById(Long id) {
        return paisRepository.findById(id);
    }

    // pegar por nome
    public Optional<Pais> getPaisByName(String nome) {
        return paisRepository.findByName(nome);
    }

    // atualizar o país
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

    // deletar
    public void deletePais(Long id) {
        if (paisRepository.existsById(id)) {
            paisRepository.deleteById(id);
        } else {
            throw new RuntimeException("País não encontrada com o ID: " + id);
        }
    }

    // listar os países
    public List<Pais> getAllPais() {
        return paisRepository.findAll();
    }

}
