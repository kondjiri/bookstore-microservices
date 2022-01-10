package com.fanedesign.bookstore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pays")

public class Pays implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



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
