package com.pt.franquicia.api.api_franquicia_pt.web.controller;

import com.pt.franquicia.api.api_franquicia_pt.persistence.entity.FranchiseEntity;
import com.pt.franquicia.api.api_franquicia_pt.service.FranchiseServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/api/franquisias")
public class FranchisesController {
    @Autowired
    private FranchiseServicesImpl franchiseServices;

    @PostMapping
    public Mono<ResponseEntity<FranchiseEntity>> addFranchises(@RequestBody FranchiseEntity franchise){
         return this.franchiseServices.addFranchises(franchise).map(
                 p->ResponseEntity
                         .created(URI.create("api/franquisias".concat(String.valueOf(p.getId()))))
                         .contentType(MediaType.APPLICATION_JSON_UTF8).body(p)

         );
    }
    @GetMapping
    public Mono<ResponseEntity<Flux<FranchiseEntity>>> listFranchises(){
        return Mono.just(ResponseEntity.ok(this.franchiseServices.listFrachises()));
    }
    @PutMapping("/name/{id}")
    public Mono<ResponseEntity<FranchiseEntity>> updateNameFranchise(@PathVariable Long id, @RequestBody FranchiseEntity franchise){
        return this.franchiseServices.getFranchise(id).flatMap(p->{
            p.setName(franchise.getName());
            return this.franchiseServices.addFranchises(p);
        }).map(
                p->ResponseEntity
                        .created(URI.create("api/franquisias".concat(String.valueOf(p.getId()))))
                        .contentType(MediaType.APPLICATION_JSON_UTF8).body(p)
        ).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
