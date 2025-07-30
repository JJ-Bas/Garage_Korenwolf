package com.novi.garage_korenwolf.models;

import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @Column(name = "id")
    private String id;

    //relatie met MaintenanceJob
    @OneToOne
    private MaintenanceJob job;

    //TODO: invoice vullen
    //TODO: dto
    //TODO: service
    //TODO: controller
    //TODO: repository
}
