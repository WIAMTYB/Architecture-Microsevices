package com.wiam.venteservice.service;

import com.wiam.venteservice.dto.VenteRequestDTO;
import com.wiam.venteservice.dto.VenteResponceDTO;

import java.util.List;

public interface VenteServiceInterface {
    public void save(VenteRequestDTO venteRequestDTO) ;
    public void delete(Long id) ;
    public void update(Long id ,VenteRequestDTO venteRequestDTO) ;
    public List<VenteResponceDTO> getAll();
    public VenteResponceDTO getVenteById(Long id);
}
