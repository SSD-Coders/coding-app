package com.example.init.repositories;

import com.example.init.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Post, Long> {
    public Post findPostById(Long id);
    void deletePostByAppUser_UsernameAndId(String username, Long id);
}
