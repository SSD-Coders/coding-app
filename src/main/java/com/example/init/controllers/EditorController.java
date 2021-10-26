package com.example.init.controllers;

import com.example.init.models.Editor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditorController {

    @GetMapping("/editor")
    public String editor(Model model) {

        model.addAttribute("editor", new Editor());
        return "editor";
    }

    @PostMapping("/editor")
    public String save(Editor editor, Model model) {

        model.addAttribute("editor", editor);
        return "saved";
    }
}
