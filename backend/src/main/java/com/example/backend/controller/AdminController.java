package com.example.backend.controller;


import com.example.backend.entity.AdminEntity;
import com.example.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController{

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public List<AdminEntity> getAllPosts() {
        return adminRepository.findAll();
    }
}