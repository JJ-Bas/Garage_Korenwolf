package com.novi.garage_korenwolf.dto;

import java.math.BigDecimal;

public abstract class JobItemDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal priceExclusiveTax;
    private double taxPercentage;
    private Long maintenanceJobId;


    // getters & setters

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

    public Long getMaintenanceJobId() {
        return maintenanceJobId;
    }

    public void setMaintenanceJobId(Long maintenanceJobId) {
        this.maintenanceJobId = maintenanceJobId;
    }
}
