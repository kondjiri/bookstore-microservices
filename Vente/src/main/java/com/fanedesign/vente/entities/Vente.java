package com.fanedesign.vente.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Vente {
    @Id
    private Long id;
    private Double price;
    @OneToMany
    private Boutique store;



}
