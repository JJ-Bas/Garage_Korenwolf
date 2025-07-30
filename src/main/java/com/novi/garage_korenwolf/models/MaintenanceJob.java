package com.novi.garage_korenwolf.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "maintenance_Job")
public class MaintenanceJob {
    @Id
    private Long id;

    //relatie met Car
    @ManyToOne
    @JoinColumn(name = "car_numberplate")
    private Car car;

    // relatie met User: MECHANIC
    @ManyToMany
    @JoinTable(
            name = "mechanic_jobs",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "user_name")
    )
    private Set<User> mechanics = new HashSet<>();

    // relatie met jobItem
    @OneToMany(mappedBy = "maintenanceJob", cascade = CascadeType.ALL)
    private List<JobItem> jobItems = new ArrayList<>();

    //relatie met invoice
    @OneToOne(mappedBy = "job", cascade = CascadeType.ALL)
    private Invoice invoice;

    private String description;
    private JobStatus jobStatus;

    public static enum JobStatus {
        PENDING,
        REJECTED,
        APPROVED,
        COMPLETED,
        PICKED_UP,
    }

    // status updates
    public void rejectJob() {
        this.jobStatus = JobStatus.REJECTED;
    }
    // TODO:Factuur aanmaken voor keuring

    public void approveJob() {
        this.jobStatus = JobStatus.APPROVED;
    }

    public void completeJob() {
        this.jobStatus = JobStatus.COMPLETED;
        //TODO:Factuur aanmaken voor afrekenen
    }

    public void pickupJob() {
        this.jobStatus = JobStatus.PICKED_UP;
    }

    // getters & setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Set<User> getMechanics() {
        return mechanics;
    }

    public void setMechanics(Set<User> mechanics) {
        this.mechanics = mechanics;
    }

    public List<JobItem> getJobItems() {
        return jobItems;
    }

    public void setJobItems(List<JobItem> jobItems) {
        this.jobItems = jobItems;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}