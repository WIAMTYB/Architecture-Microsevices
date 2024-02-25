package com.wiam.venteservice;

import com.wiam.venteservice.entities.Vente;
import com.wiam.venteservice.repositories.VenteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VenteServiceApplicationTests {

    @Autowired
    private VenteRepository venteRepository;

    @Test
    void testVenteRepository() {
        // Create instances of Vente
        Vente u1 = Vente.builder().idA(1L).build();
        Vente u2 = Vente.builder().idA(1L).build();
        Vente u3 = Vente.builder().idA(1L).build();
        Vente u4 = Vente.builder().idA(5L).build();
        Vente u5 = Vente.builder().idA(3L).build();

        // Save instances to the repository
        venteRepository.save(u1);
        venteRepository.save(u2);
        venteRepository.save(u3);
        venteRepository.save(u4);
        venteRepository.save(u5);

        // Retrieve instances from the repository
        Vente savedU1 = venteRepository.findById(u1.getIdVente()).orElse(null);
        Vente savedU2 = venteRepository.findById(u2.getIdVente()).orElse(null);
        Vente savedU3 = venteRepository.findById(u3.getIdVente()).orElse(null);
        Vente savedU4 = venteRepository.findById(u4.getIdVente()).orElse(null);
        Vente savedU5 = venteRepository.findById(u5.getIdVente()).orElse(null);

        // Perform assertions
        assertEquals(u1, savedU1);
        assertEquals(u2, savedU2);
        assertEquals(u3, savedU3);
        assertEquals(u4, savedU4);
        assertEquals(u5, savedU5);
    }
}

