package com.novi.garage_korenwolf.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")

    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false, length = 255)
        private String password;

        @Column
        private String email;

        @Column
        private String phone;

        //relatie met Role
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "name")
    )
    private Set<Role> roles = new HashSet<>();

    //relatie met MaintenanceJob
    @ManyToMany(mappedBy = "mechanics")
    private Set<MaintenanceJob> maintenanceJobs = new HashSet<>();

    //helper methods
    public boolean isMechanic() {
        return roles.stream().anyMatch(role -> role.getName().equalsIgnoreCase("MECHANIC"));
    }

    //Getters & Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<MaintenanceJob> getMaintenanceJobs() {
        return maintenanceJobs;
    }

    public void setMaintenanceJobs(Set<MaintenanceJob> maintenanceJobs) {
        this.maintenanceJobs = maintenanceJobs;
    }
}
