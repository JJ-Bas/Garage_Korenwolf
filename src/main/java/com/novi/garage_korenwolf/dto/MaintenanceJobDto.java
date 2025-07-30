package com.novi.garage_korenwolf.dto;

import java.util.List;
import java.util.Set;

public class MaintenanceJobDto {
    public Long id;

    public String description;
    private String carNumberPlate;
    private Set<String> mechanicUsernames;
    private List<Long> jobItemIds;
    private Long invoiceId;
    private String jobStatus;


    //getters en setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCarNumberPlate() {
        return carNumberPlate;
    }

    public void setCarNumberPlate(String carNumberPlate) {
        this.carNumberPlate = carNumberPlate;
    }

    public Set<String> getMechanicUsernames() {
        return mechanicUsernames;
    }

    public void setMechanicUsernames(Set<String> mechanicUsernames) {
        this.mechanicUsernames = mechanicUsernames;
    }

    public List<Long> getJobItemIds() {
        return jobItemIds;
    }

    public void setJobItemIds(List<Long> jobItemIds) {
        this.jobItemIds = jobItemIds;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
}
