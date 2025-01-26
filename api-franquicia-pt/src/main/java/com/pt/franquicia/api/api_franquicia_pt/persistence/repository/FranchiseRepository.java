package com.pt.franquicia.api.api_franquicia_pt.persistence.repository;

import com.pt.franquicia.api.api_franquicia_pt.persistence.entity.FranchiseEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FranchiseRepository extends ReactiveCrudRepository<FranchiseEntity,Long> {


}
