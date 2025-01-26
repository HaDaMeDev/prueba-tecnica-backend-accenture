package com.pt.franquicia.api.api_franquicia_pt.persistence.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@NoArgsConstructor
@Data
@Table(name = "franquicias")
public class FranchiseEntity {
    @Id
    @Column("id")
    private int id;
    @Column("nombre")
    private String name;

}
