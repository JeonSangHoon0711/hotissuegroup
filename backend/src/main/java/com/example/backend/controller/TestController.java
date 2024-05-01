package com.example.backend.controller;

import com.example.backend.entity.TestEntity;
import com.example.backend.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tests") // API의 기본 경로 설정
public class TestController {

    @Autowired
    private TestRepository testRepository;

    // 모든 테스트 엔티티 조회
    @GetMapping
    public List<TestEntity> getAllTests() {
        return testRepository.findAll();
    }
}