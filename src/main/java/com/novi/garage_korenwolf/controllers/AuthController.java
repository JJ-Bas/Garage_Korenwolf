package com.novi.garage_korenwolf.controllers;

import com.novi.garage_korenwolf.dto.AuthDto;
import com.novi.garage_korenwolf.security.JwtService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    @PostMapping("/auth")
        public ResponseEntity<Object> signIn (@RequestBody AuthDto authDto){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(authDto.username, authDto.password);
            try{
                Authentication auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
                UserDetails userDetails = (UserDetails) auth.getPrincipal();
                String token = jwtService.generateToken(userDetails);

                return ResponseEntity.ok()
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .body("Token generated");
            }
            catch (AuthenticationException authenticationException) {
                return new ResponseEntity<>(authenticationException.getMessage(), HttpStatus.UNAUTHORIZED);
            }
    }
}

