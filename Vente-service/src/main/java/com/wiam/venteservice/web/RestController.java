package com.wiam.venteservice.web;


import com.wiam.venteservice.Modele.Acheteur;
import com.wiam.venteservice.Modele.Produit;
import com.wiam.venteservice.acheteurs.AcheteurFeignController;
import com.wiam.venteservice.config.GlobalConfig;
import com.wiam.venteservice.config.VenteConfig;
import com.wiam.venteservice.dto.VenteRequestDTO;
import com.wiam.venteservice.dto.VenteResponceDTO;
import com.wiam.venteservice.entities.Vente;
import com.wiam.venteservice.produits.ProduitFeignController;
import com.wiam.venteservice.repositories.VenteRepository;
import com.wiam.venteservice.service.VenteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    VenteServiceInterface venteServiceInterface;

    @GetMapping("/ventes")
    public List<VenteResponceDTO> getAll(){return venteServiceInterface.getAll();}

    @GetMapping("/ventes/{id}")
    public VenteResponceDTO getById(@PathVariable("id") Long id){ return venteServiceInterface.getVenteById(id);}

    @PutMapping("/ventes/{id}")
    public void update_Vente(@PathVariable ("id") Long id, @RequestBody VenteRequestDTO v){venteServiceInterface.update(id,v);}

    @PostMapping("/ventes")
    public void save_vente(@RequestBody VenteRequestDTO v){
        venteServiceInterface.save(v);
    }

    @DeleteMapping("/ventes/{id}")
    public void delete_vente(@PathVariable ("id") Long id){
        venteServiceInterface.delete(id);
    }

}