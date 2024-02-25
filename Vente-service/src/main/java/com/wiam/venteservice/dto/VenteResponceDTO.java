package com.wiam.venteservice.dto;

import com.wiam.venteservice.Modele.Acheteur;
import com.wiam.venteservice.Modele.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenteResponceDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVente;
    private Long idA;
    @Transient
    private Acheteur acheteur;
   // private Long idP;
  //  @Transient
   // private Produit produit;
}