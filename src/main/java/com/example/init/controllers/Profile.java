package com.example.init.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class Profile {

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
}
