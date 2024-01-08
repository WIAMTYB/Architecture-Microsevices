package com.wiam.produitservice.repositories;


import com.wiam.produitservice.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}