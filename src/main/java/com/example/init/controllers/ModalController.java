package com.example.init.controllers;

import com.example.init.models.Post;
import com.example.init.repositories.ContentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModalController {

    @GetMapping("modal2")
    public String modal2(@RequestParam("id") Long id, Model model, Post post) {
        model.addAttribute("post", post.getBody());
        return "_modals";
    }
}

