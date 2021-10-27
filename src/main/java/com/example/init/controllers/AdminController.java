package com.example.init.controllers;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import com.example.init.models.Coders;
import com.example.init.repositories.CodersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AdminController {
    @Autowired
    CodersRepository codersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/admin")

    String admin(Model model) {
        List<Coders> coders = codersRepository.findAll();
        model.addAttribute("coders", coders);
        return "admin";
    }

    @PostMapping("/admin")
    RedirectView addCoder(String email, String username, String password, String firstName, String lastName,
            String dateOfBirth, String bio) {

        Coders newCoder = new Coders(email, username, bCryptPasswordEncoder.encode(password), firstName, lastName,
                dateOfBirth, bio);
        codersRepository.save(newCoder);
        return new RedirectView("/admin");
    }

    @GetMapping("/coder")
    public String getCoder(@RequestParam long id, Model model, Principal principal) {
        Coders coder = codersRepository.findById(id).get();
        model.addAttribute("coder", coder);
        return "coder";
    }

    @Transactional
    @GetMapping("/del/{id}")
    public RedirectView delete(@PathVariable String id, Principal principal, Model model) {
        Coders coder = codersRepository.findById(Long.parseLong(id)).orElseThrow();
        model.addAttribute("coder", principal.getName());
        codersRepository.delete(coder);
        return new RedirectView("/admin");
    }

    @GetMapping("/form/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Coders coder = codersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("coder", coder);
        return "putForm";
    }

    @Transactional
    @PostMapping("/upd/{id}")
    public RedirectView updateUser(@PathVariable("id") long id, Coders coder) {
        Coders updatedCoder = codersRepository.findById(id).orElseThrow();
        updatedCoder.setEmail(coder.getEmail());
        updatedCoder.setUsername(coder.getUsername());
        updatedCoder.setPassword(coder.getPassword());
        updatedCoder.setFirstName(coder.getFirstName());
        updatedCoder.setLastName(coder.getLastName());
        updatedCoder.setDateOfBirth(coder.getDateOfBirth());
        updatedCoder.setBio(coder.getBio());
        codersRepository.save(updatedCoder);
        return new RedirectView("/admin");
    }

}