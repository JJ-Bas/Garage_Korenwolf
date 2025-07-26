package com.novi.garage_korenwolf.dto;
import java.util.Set;

public class UserDto {
    public String username;
    public String password;

    //TODO of public String[] roles
    public Set<String> roles;



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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

}
