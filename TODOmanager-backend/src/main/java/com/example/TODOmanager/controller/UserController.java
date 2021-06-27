package com.example.TODOmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    @GetMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public String login() {
        return "authenticated successfully";
    }
}
