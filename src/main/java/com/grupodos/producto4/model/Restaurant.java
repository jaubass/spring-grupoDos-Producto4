package com.grupodos.producto4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "restaurants")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Restaurant extends AbstractAuditableEntity implements Serializable {

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String adress;
    @Column
    private String city;
    @Column
    private String postalCode;
    @Column
    private String web;

}
