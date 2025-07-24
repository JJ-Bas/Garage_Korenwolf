package com.novi.garage_korenwolf.controllers;


import com.novi.garage_korenwolf.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    //TODO:get

    //TODO:post

    //TODO:put

    //TODO:delete

}
