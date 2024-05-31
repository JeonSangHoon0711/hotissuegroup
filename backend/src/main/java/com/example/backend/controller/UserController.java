package com.example.backend.controller;

import com.example.backend.entity.UserEntity;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService; // UserService를 import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // API의 기본 경로 설정
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService; // UserService 주입

    // 모든 사용자 엔티티 조회
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // 회원가입 엔드포인트 추가
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity user) {
        try {
            UserEntity registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


