package com.wiam.customerfront.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Produit {
    private Long idP;
    private String marque;
    private String desc;
    private Float prix;
    private Integer quantite;
}
