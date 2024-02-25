package com.wiam.acheteurservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AcheteurEvent {
    private String message;
    private String staute;
    private Acheteur acheteur;




}
