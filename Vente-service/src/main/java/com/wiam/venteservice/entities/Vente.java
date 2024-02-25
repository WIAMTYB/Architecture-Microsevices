package com.wiam.venteservice.entities;


import com.wiam.venteservice.Modele.Acheteur;
import com.wiam.venteservice.Modele.Produit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVente;
    private Long idA;
    @Transient
    private Acheteur acheteur;
   // private Long idP;
   // @Transient
   // private Produit produit;
}

