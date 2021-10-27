package com.example.init.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modal")

public class IndexController {
    
    @GetMapping
    public String main(Model model) {
        return "index";
    }

    
}
