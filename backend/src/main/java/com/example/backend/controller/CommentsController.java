package com.example.backend.controller;

import com.example.backend.entity.CommentsEntity;
import com.example.backend.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comments") // API의 기본 경로 설정
public class CommentsController {

    @Autowired
    private CommentsRepository commentsRepository;
    // 모든 테스트 엔티티 조회
    @GetMapping
    public List<CommentsEntity> getAllTests() {
        System.out.println("test");
        System.out.println("222222222");
        return commentsRepository.findAll();
    }
}