package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.dto.UserDto;
import com.novi.garage_korenwolf.models.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userService.getUser(username);

        if (userDto == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        String password = userDto.getPassword();
        Set<String> roles = userDto.getRoles();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (String role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }

        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }
    }

