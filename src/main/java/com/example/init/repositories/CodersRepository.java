package com.example.init.repositories;

import com.example.init.models.Coders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodersRepository extends JpaRepository<Coders, Long> {
    public Coders findByUsername(String username);

    public Coders findUserById(Long id);
}