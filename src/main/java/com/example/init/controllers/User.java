package com.example.init.controllers;

import com.example.init.models.Coders;
import com.example.init.models.Post;
import com.example.init.repositories.CodersRepository;
import com.example.init.repositories.ContentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

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

    @Transactional
    @GetMapping("/delete/{id}")
    public RedirectView deleteUserPost(@PathVariable String id, HttpServletRequest request, Principal principal, Model model) {
        Post post = contentRepository.findById(Long.parseLong(id)).orElseThrow();
        String username = (String) request.getSession().getAttribute("username");
        Coders user = codersRepository.findByUsername(principal.getName());
        model.addAttribute("username", principal.getName());
        model.addAttribute("userProfile", user);
        contentRepository.delete(post);
        return new RedirectView("/profile");
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Post post = contentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("post", post);
        return "updateForm";
    }

    @PostMapping("/update/{id}")
    public RedirectView updateUser(@PathVariable("id") long id, Post post) {
        Post updatedPost = contentRepository.findById(id).orElseThrow();
        updatedPost.setBody(post.getBody());

        contentRepository.save(updatedPost);
//        updatedPostCoders user = codersRepository.findByUsername(principal.getName());
//        codersRepository.save(user);
//        user.setUsername(principal.getName());
//        modelodel.addAttribute("username", principal.getName());
//        model.addAttribute("userProfile", user);
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
