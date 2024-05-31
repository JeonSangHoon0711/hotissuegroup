package com.example.backend.service;

import com.example.backend.entity.UserEntity;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // UserEntity를 매개변수로 받는 메소드로 변경
    public UserEntity registerUser(UserEntity user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }
        // user.setPw(password); // 암호화 필요
        // 암호화 로직을 여기에 추가하세요.
        return userRepository.save(user);
    }
}
