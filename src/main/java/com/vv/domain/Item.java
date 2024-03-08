package com.vv.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table( name="item", schema = "vvschema")
public class Item {

    @Id
    @Column(name="id")
    String vvId;

    @Column
    String name;

}
