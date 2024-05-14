package com.example.backend.controller;


import com.example.backend.entity.PostEntity;
import com.example.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }
}