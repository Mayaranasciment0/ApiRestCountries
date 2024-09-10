package com.example.demo.service;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // private final String API_URL = "https://restcountries.com/v3.1/all";

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public Optional<Country> getCountryById(long id) {
        return countryRepository.findById(id);
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    public void deleteCountry(long id) {
        countryRepository.deleteById(id);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

}
