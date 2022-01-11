package com.fanedesign.bookstore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "adresse")

public class Address implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String _id;
    private String porte;

    @ManyToOne
    private Quartier quartier;



    private LocalDateTime _createdAt;
    private LocalDateTime _updateAt;


    @PrePersist
    public  void onCreate(){
        this._createdAt = LocalDateTime.now();
        this._updateAt = LocalDateTime.now();
    }

    @PreUpdate
    public  void onUpdate(){
        this._updateAt = LocalDateTime.now();
    }
}
