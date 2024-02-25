package com.wiam.venteservice.repositories;

import com.wiam.venteservice.entities.Vente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class VenteRepositoryTest {

    @Autowired
    private VenteRepository venteRepository;

    @Test
    public void testSaveVente() {
        Vente vente = Vente.builder().idA(1L).build();
        Vente savedVente = venteRepository.save(vente);

        assertThat(savedVente.getIdVente()).isNotNull();
        assertThat(savedVente.getIdA()).isEqualTo(vente.getIdA());
      //  assertThat(savedVente.getIdP()).isEqualTo(vente.getIdP());
    }

    @Test
    public void testFindAll() {
        Vente vente1 = Vente.builder().idA(1L).build();
        Vente vente2 = Vente.builder().idA(1L).build();

        venteRepository.save(vente1);
        venteRepository.save(vente2);

        List<Vente> ventes = venteRepository.findAll();

        assertThat(ventes).isNotEmpty();
        assertThat(ventes.size()).isEqualTo(7);
        assertThat(ventes).contains(vente1, vente2);
    }

    @Test
    public void testFindById() {
        Vente vente = Vente.builder().idA(1L).build();
        venteRepository.save(vente);

        Optional<Vente> foundVente = venteRepository.findById(vente.getIdVente());

        assertThat(foundVente).isPresent();
        assertThat(foundVente.get().getIdVente()).isEqualTo(vente.getIdVente());
    }

    @Test
    public void testUpdateVente() {
        Vente vente = Vente.builder().idA(1L).build();
        Vente savedVente = venteRepository.save(vente);

       // savedVente.setIdP(3L);
        Vente updatedVente = venteRepository.save(savedVente);

      //  assertThat(updatedVente.getIdP()).isEqualTo(3);
    }

    @Test
    public void testDeleteVente() {
        Vente vente = Vente.builder().idA(1L).build();
        venteRepository.save(vente);

        venteRepository.deleteById(vente.getIdVente());

        Optional<Vente> deletedVente = venteRepository.findById(vente.getIdVente());
        assertThat(deletedVente).isEmpty();
    }

}
