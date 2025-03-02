package com.pt.franquicia.api.api_franquicia_pt.service;

import com.pt.franquicia.api.api_franquicia_pt.persistence.entity.FranchiseEntity;
import com.pt.franquicia.api.api_franquicia_pt.persistence.repository.FranchiseRepository;
import com.pt.franquicia.api.api_franquicia_pt.service.interfaces.FranchiseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FranchiseServicesImpl implements FranchiseServices {
    @Autowired
    private  final FranchiseRepository franchiseRepository;

    public FranchiseServicesImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    public Mono<FranchiseEntity> addFranchises(FranchiseEntity franchises){
        return this.franchiseRepository.save(franchises);
    }

    public Flux<FranchiseEntity> listFrachises(){
        return this.franchiseRepository.findAll();
    }

    @Override
    public Mono<FranchiseEntity> getFranchise(Long id) {
        return this.franchiseRepository.findById(id);
    }





}
