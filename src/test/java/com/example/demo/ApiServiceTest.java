package com.example.demo;

import com.example.demo.model.Pais;
import com.example.demo.service.ApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiServiceTest {

    @Autowired
    private ApiService apiService;

    @Test
    void testGetAllPaisesFromApi() {
        List<Pais> paises = apiService.getAllPaisesFromApi();
        assertNotNull(paises);
        assertTrue(paises.size() > 0);
    }
}