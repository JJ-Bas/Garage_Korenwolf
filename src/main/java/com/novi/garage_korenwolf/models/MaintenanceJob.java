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


    // getters & setters

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

//deze class wordt uitgebreid met Part en WorkPerformed