package com.wiam.venteservice.mapper;

import com.wiam.venteservice.dto.VenteRequestDTO;
import com.wiam.venteservice.dto.VenteResponceDTO;
import com.wiam.venteservice.entities.Vente;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class VenteInterfaceMapImpl implements VenteInterfaceMap{
    @Override
    public Vente requestDTO_ToVente(VenteRequestDTO venteRequestDTO) {
        Vente v=new Vente();
        BeanUtils.copyProperties(venteRequestDTO,v);
        return v;
    }

    @Override
    public VenteResponceDTO vente_ToResponseDTO(Vente vente) {
        VenteResponceDTO vDTO =new VenteResponceDTO();
        BeanUtils.copyProperties(vente,vDTO);
        return vDTO;
    }
}
