package com.wiam.venteservice.service;

import com.wiam.venteservice.Modele.Acheteur;
import com.wiam.venteservice.Modele.Produit;
import com.wiam.venteservice.acheteurs.AcheteurFeignController;
import com.wiam.venteservice.dto.VenteRequestDTO;
import com.wiam.venteservice.entities.Vente;
import com.wiam.venteservice.mapper.VenteInterfaceMap;
import com.wiam.venteservice.produits.ProduitFeignController;
import com.wiam.venteservice.repositories.VenteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class VenteServiceInterfaceImplTest {

    @Mock
    private VenteRepository venteRepository;

    @Mock
    private VenteInterfaceMap venteInterfaceMap;

   // @Mock
  //  private ProduitFeignController produitFeignController;

    @Mock
    private AcheteurFeignController acheteurFeignController;

    @InjectMocks
    private VenteServiceInterfaceImpl venteService;

    @Test
    public void testSave() {
        VenteRequestDTO venteRequestDTO = new VenteRequestDTO();
        Vente venteMapped = new Vente();

        when(venteInterfaceMap.requestDTO_ToVente(venteRequestDTO)).thenReturn(venteMapped);

        venteService.save(venteRequestDTO);

        verify(venteRepository, times(1)).save(venteMapped);
    }

    @Test
    public void testDelete() {
       Long venteIdToDelete = 1L;

        venteService.delete(venteIdToDelete);

        verify(venteRepository, times(1)).deleteById(venteIdToDelete);
    }

    @Test
    public void testUpdate() {
     Long venteIdToUpdate = 1L;
        VenteRequestDTO venteRequestDTO = new VenteRequestDTO(/* Initialisez l'objet VenteRequestDTO simulé ici */);
        Vente existingVente = new Vente(/* Initialisez l'objet Vente existant ici */);

        when(venteRepository.findById(venteIdToUpdate)).thenReturn(Optional.of(existingVente));

        venteService.update(venteIdToUpdate, venteRequestDTO);

        verify(venteRepository, times(1)).save(existingVente);
        // Ajoutez des assertions spécifiques en fonction de vos besoins
    }

    @Test
    public void testGetAll() {
        List<Produit> produits = new ArrayList<>(); // Initialisez la liste des produits simulée
        List<Acheteur> acheteurs = new ArrayList<>(); // Initialisez la liste des acheteurs simulée
        List<Vente> ventes = new ArrayList<>(); // Initialisez la liste des ventes simulée

       // when(produitFeignController.getAll()).thenReturn(produits);
        when(acheteurFeignController.getAll()).thenReturn(acheteurs);
        when(venteRepository.findAll()).thenReturn(ventes);

        venteService.getAll();

        // Vérifiez que les méthodes correspondantes ont été appelées le bon nombre de fois
       // verify(produitFeignController, times(1)).getAll();
        verify(acheteurFeignController, times(1)).getAll();
        verify(venteRepository, times(1)).findAll();
        // Ajoutez d'autres assertions spécifiques en fonction de vos besoins
    }

    @Test
    public void testGetVenteById() {
        Long venteIdToRetrieve = 1L;
        Vente vente = new Vente(/* Initialisez l'objet Vente simulé ici */);
        Acheteur acheteur = new Acheteur(/* Initialisez l'objet Acheteur simulé ici */);
       // Produit produit = new Produit(/* Initialisez l'objet Produit simulé ici */);

        when(venteRepository.findById(venteIdToRetrieve)).thenReturn(Optional.of(vente));
        when(acheteurFeignController.getById(vente.getIdA())).thenReturn(acheteur);
       // when(produitFeignController.getById(vente.getIdP())).thenReturn(produit);

        venteService.getVenteById(venteIdToRetrieve);

        // Vérifiez que les méthodes correspondantes ont été appelées le bon nombre de fois
        verify(venteRepository, times(1)).findById(venteIdToRetrieve);
        verify(acheteurFeignController, times(1)).getById(vente.getIdA());
       // verify(produitFeignController, times(1)).getById(vente.getIdP());
        // Ajoutez d'autres assertions spécifiques en fonction de vos besoins
    }

    // Ajoutez d'autres méthodes de test au besoin
}

