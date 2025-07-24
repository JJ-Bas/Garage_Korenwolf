package com.novi.garage_korenwolf.services;

import com.novi.garage_korenwolf.dto.UserDto;
import com.novi.garage_korenwolf.models.Role;
import com.novi.garage_korenwolf.models.User;
import com.novi.garage_korenwolf.repositories.RoleRepository;
import com.novi.garage_korenwolf.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public UserDto createUser(UserDto userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.username);
        newUser.setPassword(encoder.encode(userDto.password));
        Set<Role> userRoles = newUser.getRoles();
        for (String rolename: userDto.roles) {
            Optional<Role> or = roleRepository.findById("ROLE_" + rolename);
            if (or.isPresent()){
                userRoles.add(or.get());
        }
        }

        userRepository.save(newUser);
        userDto.username = newUser.getUsername();
        return userDto;
    }

}
