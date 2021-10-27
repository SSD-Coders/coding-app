package com.example.init.repositories;

import com.example.init.models.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {
    @Autowired
    private ContentRepository contentRepository;

    public void update (Post post){
        contentRepository.save(post);
    }
    
}
