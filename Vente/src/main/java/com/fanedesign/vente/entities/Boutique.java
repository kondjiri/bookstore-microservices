package com.fanedesign.vente.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity

public class Boutique {
    private Long id;
    private String nameStore;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne
    private Vente vente;
}
