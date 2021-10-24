package com.example.init.repositories;

import com.example.init.models.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepositories extends JpaRepository<Code,Long> {

}
