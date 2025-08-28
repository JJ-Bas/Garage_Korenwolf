package com.novi.garage_korenwolf.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.*;
import java.math.BigDecimal;


//deze class wordt uitgebreid met Part en WorkPerformed

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type" // JSON must include this field
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Part.class, name = "part"),
        @JsonSubTypes.Type(value = WorkPerformed.class, name = "workPerformed")
})

public abstract class JobItem {

    @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_item_seq")
    private Long id;

    // relatie met MaintenanceJob
    @ManyToOne
    @JoinColumn(name = "maintenance_job_id")
    private MaintenanceJob maintenanceJob;

    // Gemeenschappelijke velden
    private String name;
    private String description;
    private BigDecimal priceExclusiveTax;
    private double taxPercentage;

    // getter & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaintenanceJob getMaintenanceJob() {
        return maintenanceJob;
    }

    public void setMaintenanceJob(MaintenanceJob maintenanceJob) {
        this.maintenanceJob = maintenanceJob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPriceExclusiveTax() {
        return priceExclusiveTax;
    }

    public void setPriceExclusiveTax(BigDecimal priceExclusiveTax) {
        this.priceExclusiveTax = priceExclusiveTax;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}