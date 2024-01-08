package com.wiam.venteservice.produits;

import com.wiam.venteservice.Modele.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PRODUIT-SERVICE")

public interface ProduitFeignController {
    @GetMapping("/produits")
    public List<Produit> findAll();

    @GetMapping("/produits/{id}")
    public Produit findBy(@PathVariable Long id);
}
