package com.wiam.venteservice.web;


import com.wiam.venteservice.Modele.Acheteur;
import com.wiam.venteservice.Modele.Produit;
import com.wiam.venteservice.acheteurs.AcheteurFeignController;
import com.wiam.venteservice.config.GlobalConfig;
import com.wiam.venteservice.config.VenteConfig;
import com.wiam.venteservice.entities.Vente;
import com.wiam.venteservice.produits.ProduitFeignController;
import com.wiam.venteservice.repositories.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    VenteRepository venteRepository;

    @Autowired
    private ProduitFeignController produitFeignController;

    @Autowired
    private AcheteurFeignController acheteurFeignController;

    @Autowired
    GlobalConfig globalConfig;

    @Autowired
    VenteConfig venteConfig;

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){ return globalConfig;}

    @GetMapping("/venteConfig")
    public  VenteConfig venteConfig(){ return venteConfig;}

    @GetMapping("/ventes")
    public List<Vente> getAll(){
        List<Vente> lv = venteRepository.findAll();

        List<Produit> lp = produitFeignController.findAll();

        List<Acheteur> la = acheteurFeignController.findAll();

        for (Vente v:lv){
            for (Produit p:lp){
                if (v.getIdP() == p.getIdP()){
                    v.setProduit(p); break;
                }
            }
        }

        for (Vente v:lv){
            for (Acheteur a:la){
                if (v.getIdA() == a.getIdA()){
                    v.setAcheteur(a); break;
                }
            }
        }

        return lv;
    }

    @GetMapping("/ventes/{id}")
    public Vente getById(@PathVariable Long id){

        Vente v = venteRepository.findById(id).get();

        Acheteur a = acheteurFeignController.findBy(v.getIdA());
        v.setAcheteur(a);

        Produit p = produitFeignController.findBy(v.getIdP());
        v.setProduit(p);

        return v;
    }




}