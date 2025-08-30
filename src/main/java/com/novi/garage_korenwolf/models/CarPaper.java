package com.novi.garage_korenwolf.models;

import jakarta.persistence.*;

@Entity
public class CarPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;

    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;
}
