package com.novi.garage_korenwolf.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //TODO: of JOINED of SINGLE_TABLE??
@DiscriminatorColumn(name = "item_type")
public abstract class JobItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //relatie met MaintenanceJob
    @ManyToOne
    @JoinColumn(name = "maintenance_job_id")
    private MaintenanceJob maintenanceJob;

    // Gemeenschappelijke velden
    private String description;
    private int price;
    private BigDecimal priceExclusiveTax;
    private double taxPercentage;

}
