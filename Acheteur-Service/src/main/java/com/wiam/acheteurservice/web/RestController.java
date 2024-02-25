package com.wiam.acheteurservice.web;

import com.wiam.acheteurservice.config.AcheteurConfig;
import com.wiam.acheteurservice.config.GlobalConfig;
import com.wiam.acheteurservice.entities.Acheteur;
import com.wiam.acheteurservice.repositories.AcheteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@org.springframework.web.bind.annotation.RestController


public class RestController {
    @Autowired
    AcheteurRepository acheteurRepository;

    @Autowired
    GlobalConfig globalConfig;

    @Autowired
    AcheteurConfig acheteurConfig;
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
       return globalConfig;
   }

    @GetMapping("/acheteurConfig")
    public AcheteurConfig acheteurConfig(){ return acheteurConfig;}

    @GetMapping("/acheteurs")
    public List<Acheteur> getAll(){
        List<Acheteur> la = acheteurRepository.findAll();
        return la;
    }

    @GetMapping("/acheteurs/{id}")
    public Acheteur getById(@PathVariable ("id") Integer id){
        Acheteur e = acheteurRepository.findById(id).get();
        return e;
    }
    @PutMapping("/acheteurs/{id}")
    public Acheteur updateClient(@PathVariable Integer id,@RequestBody Acheteur acheteur){
        Acheteur a = acheteurRepository.findById(id).orElseThrow(()-> new RuntimeException("Acheteur not found"));
        a.setNom(acheteur.getNom());
        a.setVille(acheteur.getVille());

       kafkaTemplate.send("acheteur","acheteur"+id +" updated");

        return acheteurRepository.save(a);
    }
    @PostMapping("/acheteurs")
    public Acheteur saveClient(@RequestBody Acheteur acheteur){
        Acheteur a = new Acheteur();
        a.setNom(acheteur.getNom());
        a.setVille(acheteur.getVille());
        return acheteurRepository.save(a);
    }
    @DeleteMapping("/acheteurs/{id}")
    public void deleteClient(@PathVariable Integer id){
        acheteurRepository.deleteById(id);
        kafkaTemplate.send("acheteur","acheteur "+id +" deleted");
    }
}














     /*@PutMapping("/acheteurs/{id}")
    public void save(@PathVariable ("id") Integer id, @RequestBody Acheteur a){
        Acheteur ar = acheteurRepository.findById(id).get();

        if(a.getNom()!=null) {ar.setNom(a.getNom());}
        if(a.getVille()!=null){ar.setVille(a.getVille());}

        acheteurRepository.save(ar);
    }

    @PostMapping("/acheteurs")
    public void add(@RequestBody Acheteur a){
        acheteurRepository.save(a);
    }

    @DeleteMapping("/acheteurs/{id}")
    public void supprimer(@PathVariable ("id") Integer id){
        acheteurRepository.deleteById(id);
    }*/



