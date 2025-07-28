package com.novi.garage_korenwolf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;  // Dit moet User zijn, niet Role

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setname(String rolename) {
        this.name = rolename;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
