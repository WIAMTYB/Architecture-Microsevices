package com.wiam.acheteurservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Acheteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idA;
    private String nom;
    private String ville;

}