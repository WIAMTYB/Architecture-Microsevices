package com.wiam.venteservice.acheteurs;

import com.wiam.venteservice.Modele.Acheteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ACHETEUR-SERVICE")
public interface AcheteurFeignController {

    @GetMapping("/acheteurs")
    public List<Acheteur> findAll();

    @GetMapping("/acheteurs/{id}")
    public Acheteur findBy(@PathVariable Long id);
}