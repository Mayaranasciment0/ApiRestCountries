package com.example.demo.service;

import com.example.demo.model.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    // URL da API Rest Countries
    private static final String REST_COUNTRIES_API_URL = "https://restcountries.com/v3.1/all";

    public List<Pais> getAllPaisesFromApi() {
        // Faz a chamada à API Rest Countries
        Pais[] paisesArray = restTemplate.getForObject(REST_COUNTRIES_API_URL, Pais[].class);
        
        if (paisesArray != null) {
            return Arrays.asList(paisesArray);
        } else {
            throw new RuntimeException("Erro ao obter a lista de países da API");
        }
    }
}