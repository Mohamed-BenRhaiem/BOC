package com.example.boc.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthController {

    private final UserDetailsService userDetailsService;

    public AuthController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @GetMapping
    public UserDetails getUser() {
        // Assuming "Sami" is the username you're retrieving details for
        UserDetails userDetails = userDetailsService.loadUserByUsername("Sami");
        return userDetails;
    }


}
