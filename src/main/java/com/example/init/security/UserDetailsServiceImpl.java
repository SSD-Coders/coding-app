package com.example.init.security;

import com.example.init.models.Coders;
import com.example.init.repositories.CodersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    CodersRepository codersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Coders coders = codersRepository.findByUsername(username);
        if (coders == null) {
            throw new UsernameNotFoundException((username + " not found!"));
        }
        return coders;
    }
}
