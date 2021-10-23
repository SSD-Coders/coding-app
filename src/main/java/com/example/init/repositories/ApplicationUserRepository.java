package com.example.init.repositories;

import com.example.init.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository <ApplicationUser, Long>{
    public ApplicationUser findByUsername(String username);
}
