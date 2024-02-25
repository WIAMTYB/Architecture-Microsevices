package com.wiam.venteservice.web;

import com.wiam.venteservice.dto.VenteRequestDTO;
import com.wiam.venteservice.dto.VenteResponceDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static graphql.Assert.assertFalse;
import static graphql.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class VenteRestControlerTest {


    @Autowired
    private RestController restController;

    @Test
    public void testGetAll() throws Exception {

        // Arrange (initialisation)
        List<VenteResponceDTO> venteResponseDTOS=new ArrayList<>();

        // Act (appelle la methode doit tester)
        venteResponseDTOS= restController.getAll();

        // Assert (verifier le resultat)
        assertNotNull(venteResponseDTOS);
        assertFalse(venteResponseDTOS.isEmpty());

    }

    @Test
    public void testGetById() throws Exception {

        // Arrange (initialisation)
         Long idVente=1L;
        VenteResponceDTO venteResponseDTO=new VenteResponceDTO();

        // Act (appelle la methode doit tester)
        venteResponseDTO= restController.getById(idVente);

        // Assert (verifier le resultat)
        assertNotNull(venteResponseDTO);
        assertEquals(idVente,venteResponseDTO.getIdVente());


    }

    @Test
    public void testUpdate_Vente() throws Exception {

        // Arrange (initialisation)
        Long idVente=1L;
        VenteResponceDTO venteResponseDTO=new VenteResponceDTO();
       //comme je vais faire lajoutt dans postman
        VenteRequestDTO venteNouveau=VenteRequestDTO.builder().idVente(idVente)
                .idA(1L)
              //  .idP(1L)
                .build();

        // Act (appelle la methode doit tester)
      restController.update_Vente(idVente,venteNouveau);
        venteResponseDTO=restController.getById(idVente);

        // Assert (verifier le resultat)
        assertEquals(venteNouveau.getIdVente(),venteResponseDTO.getIdVente());
        assertEquals(venteNouveau.getIdA(),venteResponseDTO.getIdA());
        //assertEquals(venteNouveau.getIdP(),venteResponseDTO.getIdP());

    }


    @Test
    public void testSave_vente() {
        // Arrange
        VenteRequestDTO venteRequestDTO = VenteRequestDTO.builder()
                .idA(4L)
               // .idP(1L)
                .build();

        // Act
     restController.save_vente(venteRequestDTO);

        // Assert
        // Ajoutez des assertions pour vérifier la sauvegarde
        List<VenteResponceDTO> allVentes = restController.getAll();

        // Vérifiez que la nouvelle vente est présente dans la liste
        assertFalse(allVentes.isEmpty());

        // Vérifiez que venteRequestDTO est dans la liste
    }


    @Test
    public void testDelete_vente() {
        // Arrange
       Long id = 1L;

        // Act
       restController.delete_vente(id);

        // Assert


        // Vérifiez que la vente avec l'ID spécifié n'est plus présente dans la liste
        List<VenteResponceDTO> allVentes = restController.getAll();
        assertFalse(allVentes.stream().anyMatch(v -> id.equals(v.getIdVente())));
    }






}



