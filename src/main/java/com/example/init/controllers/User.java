package com.example.init.controllers;

import antlr.BaseAST;
import com.example.init.models.ApplicationUser;
import com.example.init.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class User {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup";
    }

    @GetMapping("/login")
    public String getSignInPage() {
        return "login";
    }

    @PostMapping("/signup")
    public RedirectView attemptSignUp(@ModelAttribute ApplicationUser user) {
        ApplicationUser newUser = new ApplicationUser(user.getEmail(),user.getUsername(),
                bCryptPasswordEncoder.encode(user.getPassword()),
                user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getBio());
        applicationUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/login");
    }

    @PostMapping("/login")
    public RedirectView loginResponse(@ModelAttribute ApplicationUser user, Model model) {
        model.addAttribute("username", applicationUserRepository.findByUsername(user.getUsername()));
        return new RedirectView("profile");
    }

    @GetMapping("/profile")
    public String getUserProfile(Principal principal, Model model) {
        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());
        model.addAttribute("username", principal.getName());
        model.addAttribute("userProfile", user);
        return "profile";
    }

}
