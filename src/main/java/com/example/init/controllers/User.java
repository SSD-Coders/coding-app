package com.example.init.controllers;

import com.example.init.models.Coders;
import com.example.init.models.Post;
import com.example.init.repositories.CodersRepository;
import com.example.init.repositories.ContentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class User {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    CodersRepository codersRepository;

    @Autowired
    ContentRepository contentRepository;

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup";
    }

    @GetMapping("/login")
    public String getSignInPage() {
        return "login";
    }

    @PostMapping("/signup")
    public RedirectView attemptSignUp(@ModelAttribute Coders user) {
        Coders newUser = new Coders(user.getEmail(), user.getUsername(),
                bCryptPasswordEncoder.encode(user.getPassword()), user.getFirstName(), user.getLastName(),
                user.getDateOfBirth(), user.getBio());
        codersRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/login");
    }

    @PostMapping("/login")
    public RedirectView loginResponse(@ModelAttribute Coders user, Model model) {
        model.addAttribute("username", codersRepository.findByUsername(user.getUsername()));
        return new RedirectView("profile");
    }

    @GetMapping("/profile")
    public String getUserProfile(Principal principal, Model model) {
        Coders user = codersRepository.findByUsername(principal.getName());
        model.addAttribute("username", principal.getName());
        model.addAttribute("userProfile", user);
        return "profile";
    }

    @PostMapping("/addPost")
    public RedirectView addPost(Principal principle, String body) {
        Coders newUser = codersRepository.findByUsername(principle.getName());
        Post post = new Post(newUser, body);
        contentRepository.save(post);
        return new RedirectView("/profile");
    }

    @GetMapping("/user")
    public String profile(@RequestParam long id, Model model, Principal principal) {
        Coders user = codersRepository.findById(id).get();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("userProfile", user);
        model.addAttribute("logged", ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        return "user";
    }

    @GetMapping("/users")
    public String getUsers(Model model, Principal principal) {
        List<Coders> users = codersRepository.findAll();
        model.addAttribute("allusers", users);
        Coders user = codersRepository.findByUsername(principal.getName());
        model.addAttribute("username", user.getUsername());
        return "users";
    }

    @PostMapping("/follow")
    public RedirectView followUser(@AuthenticationPrincipal Coders user, @RequestParam Long id) {
        Coders feed = codersRepository.findByUsername(user.getUsername());
        Coders follow = codersRepository.findById(id).get();
        feed.getFollowers().add(follow);
        codersRepository.save(feed);
        return new RedirectView("/feed");
    }

    @GetMapping("/feed")
    public String getUsersInfo(@AuthenticationPrincipal Coders user, Model model) {
        Coders feed = codersRepository.findByUsername(user.getUsername());
        List<Coders> following = feed.getFollowers();
        model.addAttribute("followers", following);
        return "feed";
    }
}
