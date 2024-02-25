package com.wiam.venteservice.mapper;

import com.wiam.venteservice.dto.VenteRequestDTO;
import com.wiam.venteservice.dto.VenteResponceDTO;
import com.wiam.venteservice.entities.Vente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VenteInterfaceMapImplTest {

    @Autowired
    VenteInterfaceMap venteInterfaceMap;


    @Test
    public void testRequestDTO_ToVente() {
        // Créer un objet VenteRequestDTO pour le test
        VenteRequestDTO requestDTO=new VenteRequestDTO();
        requestDTO.setIdVente(1L);
        requestDTO.setIdA(2L);
       // requestDTO.setIdP(3L);
        // Appeler la méthode de mappage
        Vente vente=venteInterfaceMap.requestDTO_ToVente(requestDTO);

        // Vérifier si les propriétés ont été correctement copiées
        assertEquals(requestDTO.getIdVente(), vente.getIdVente());
        assertEquals(requestDTO.getIdA(), vente.getIdA());
      //  assertEquals(requestDTO.getIdP(), vente.getIdP());


    }

    @Test
    public void testVente_ToResponseDTO() {
        // Créer un objet Vente pour le test
        Vente vente=new Vente();
        vente.setIdVente(1L);
        vente.setIdA(2L);
       // vente.setIdP(3L);
        // Appeler la méthode de mappage
        VenteResponceDTO responseDTO=venteInterfaceMap.vente_ToResponseDTO(vente);

        // Vérifier si les propriétés ont été correctement copiées
        assertEquals(vente.getIdVente(), responseDTO.getIdVente());
        assertEquals(vente.getIdA(), responseDTO.getIdA());
      //  assertEquals(vente.getIdP(), responseDTO.getIdP());

    }


}