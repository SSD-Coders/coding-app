package com.example.init.controllers;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Aboutus {

    @GetMapping("/aboutus")
    public String getAboutUs(){
        return"aboutus";
    }
    
}
