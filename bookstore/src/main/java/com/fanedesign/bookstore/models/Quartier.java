package com.fanedesign.bookstore.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class Quartier implements Serializable {
    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String _id;
    private String name;
}
