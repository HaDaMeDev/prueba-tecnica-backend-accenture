package com.pt.franquicia.api.api_franquicia_pt.service.interfaces;

import com.pt.franquicia.api.api_franquicia_pt.persistence.entity.FranchiseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseServices {
    public Mono<FranchiseEntity> addFranchises(FranchiseEntity franchises);

    public Flux<FranchiseEntity> listFrachises();
    public Mono<FranchiseEntity> getFranchise(Long id);



}
