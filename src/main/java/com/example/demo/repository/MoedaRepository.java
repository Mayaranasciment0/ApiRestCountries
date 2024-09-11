package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Country;

@Repository
public interface MoedaRepository extends JpaRepository<Moeda, Long> {

    Moeda findByCodigo(String codigo);
}
