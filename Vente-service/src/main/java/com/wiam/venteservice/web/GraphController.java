package com.wiam.venteservice.web;


import com.wiam.venteservice.dto.VenteRequestDTO;
import com.wiam.venteservice.dto.VenteResponceDTO;
import com.wiam.venteservice.service.VenteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphController {

    @Autowired
    VenteServiceInterface venteServiceInterface;

    @QueryMapping
    public List<VenteResponceDTO> getAllAcheteurs(){return venteServiceInterface.getAll();}

    @QueryMapping
    public VenteResponceDTO getAcheteurById(@Argument Long id){ return venteServiceInterface.getVenteById(id);}


    @MutationMapping
    public void save(@Argument VenteRequestDTO venteRequestDTO) {venteServiceInterface.save(venteRequestDTO);}

    @MutationMapping
    public void delete(@Argument Long id  ) {venteServiceInterface.delete(id);}

    @MutationMapping
    public void update(@Argument Long id ,@Argument VenteRequestDTO input) {venteServiceInterface.update(id, input);}









}
