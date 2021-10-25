package com.example.init.repositories;

import com.example.init.models.Coders;
import com.example.init.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


@Repository

public interface ContentRepository extends JpaRepository<Post, Long> {
}
