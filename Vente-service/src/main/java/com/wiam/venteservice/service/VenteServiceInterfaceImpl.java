package com.wiam.venteservice.service;

import com.wiam.venteservice.Modele.Acheteur;
import com.wiam.venteservice.Modele.Produit;
import com.wiam.venteservice.acheteurs.AcheteurFeignController;
import com.wiam.venteservice.dto.VenteRequestDTO;
import com.wiam.venteservice.dto.VenteResponceDTO;
import com.wiam.venteservice.entities.Vente;
import com.wiam.venteservice.mapper.VenteInterfaceMap;
import com.wiam.venteservice.produits.ProduitFeignController;
import com.wiam.venteservice.repositories.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service

@Transactional
public class VenteServiceInterfaceImpl implements VenteServiceInterface {

    @Autowired
    VenteRepository venteRepository;

    @Autowired
    VenteInterfaceMap venteInterfaceMap;

   // @Autowired
   // ProduitFeignController produitFeignController;

    @Autowired
    AcheteurFeignController acheteurFeignController;


    @Override
    public void save(VenteRequestDTO venteRequestDTO) {
        Vente v =new Vente();
        v=venteInterfaceMap.requestDTO_ToVente(venteRequestDTO);
        venteRepository.save(v);
    }

    @Override
    public void delete(Long id) { venteRepository.deleteById((id));}

    @Override
    public void update(Long id, VenteRequestDTO venteRequestDTO) {

        Vente v=venteRepository.findById(Long.valueOf(id)).get();
        if(venteRequestDTO.getIdVente() != null) v.setIdVente(venteRequestDTO.getIdVente());
        if(venteRequestDTO.getIdA() != null) v.setIdA(venteRequestDTO.getIdA());
       // if(venteRequestDTO.getIdP() != null) v.setIdP(venteRequestDTO.getIdP());

        venteRepository.save(v);
    }

    @Override
    public List<VenteResponceDTO> getAll() {
        //List<Produit> lp=produitFeignController.getAll();
        List<Acheteur> la=acheteurFeignController.getAll();

        List<Vente> Liste_ventes= new ArrayList<Vente>();
        Liste_ventes=venteRepository.findAll();
        List<VenteResponceDTO> Liste_ventesRespenseDTO=new ArrayList<VenteResponceDTO>();

        for (Vente vente:Liste_ventes)
        {
            for(Acheteur acheteur:la){
                if(vente.getIdA()==acheteur.getIdA()){ vente.setAcheteur(acheteur); break;}
            }
           // for(Produit produit:lp){
            //    if(vente.getIdP()==produit.getIdP()){ vente.setProduit(produit); break;}
           // }
            VenteResponceDTO r=venteInterfaceMap.vente_ToResponseDTO(vente);
            Liste_ventesRespenseDTO.add(r);

        }

        return Liste_ventesRespenseDTO;
    }

    @Override
    public VenteResponceDTO getVenteById(Long id) {
        Vente vente=venteRepository.findById(id).get();
        Acheteur acheteur=acheteurFeignController.getById(vente.getIdA());
      //  Produit produit=produitFeignController.getById(vente.getIdP());
        vente.setAcheteur(acheteur);
       // vente.setProduit(produit);
        return venteInterfaceMap.vente_ToResponseDTO(vente);
    }
}