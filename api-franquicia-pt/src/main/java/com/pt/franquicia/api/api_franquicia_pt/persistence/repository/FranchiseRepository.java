package com.pt.franquicia.api.api_franquicia_pt.persistence.repository;

import com.pt.franquicia.api.api_franquicia_pt.persistence.entity.FranchiseEntity;
import com.pt.franquicia.api.api_franquicia_pt.service.dto.UpdateFranchiseNameDto;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FranchiseRepository extends ReactiveCrudRepository<FranchiseEntity,Long> {
    @Query(value =
            "UPDATE franquicias " +
                    "SET nombre = :#{#newFranchiseName.newName} " +
                    "WHERE id = :#{#newFranchiseName.getId}")
    @Modifying
    void updateFranchiseName(@Param("newName") UpdateFranchiseNameDto newFranchiseName);

}
