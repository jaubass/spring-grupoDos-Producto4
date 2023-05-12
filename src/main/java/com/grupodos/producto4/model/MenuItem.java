package com.grupodos.producto4.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "menuitems")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MenuItem extends AbstractAuditableEntity<Long> implements Serializable {

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double price ;
    @Column
    private String category;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

}
