package com.example.backend.controller;

import com.example.backend.entity.UserEntity;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users") // API의 기본 경로 설정
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 모든 테스트 엔티티 조회
    @GetMapping
    public List<UserEntity> getAllTests() {
        System.out.println("test");
        System.out.println("222222222");
        return userRepository.findAll();
    }
}