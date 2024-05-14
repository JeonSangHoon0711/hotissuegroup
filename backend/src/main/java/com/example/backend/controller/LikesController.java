package com.example.backend.controller;

import com.example.backend.entity.LikesEntity;
import com.example.backend.repository.LikesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikesController {

    private static final Logger logger = LoggerFactory.getLogger(LikesController.class);

    @Autowired
    private LikesRepository likesRepository;

    // 모든 좋아요 조회
    @GetMapping
    public List<LikesEntity> getAllLikes() {
        List<LikesEntity> likes = likesRepository.findAll();
        logger.info("조회된 좋아요 수: {}", likes.size());
        likes.forEach(like -> logger.info(like.toString()));
        return likes;
    }

    // 여기에 추가적인 엔드포인트를 정의할 수 있습니다.
}
