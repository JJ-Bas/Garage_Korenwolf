package com.novi.garage_korenwolf.models;

import jakarta.persistence.*;

import java.util.Set;


@Entity
    @Table(name = "users")

    public class User {
        @Id
        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false, length = 255)
        private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private Set<Role> roles;

}
