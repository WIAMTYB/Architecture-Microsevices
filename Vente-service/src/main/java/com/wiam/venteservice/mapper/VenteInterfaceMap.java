package com.wiam.venteservice.mapper;

import com.wiam.venteservice.dto.VenteRequestDTO;
import com.wiam.venteservice.dto.VenteResponceDTO;
import com.wiam.venteservice.entities.Vente;

public interface VenteInterfaceMap {
    public Vente requestDTO_ToVente(VenteRequestDTO venteRequestDTO);
    public VenteResponceDTO vente_ToResponseDTO(Vente vente);
}


