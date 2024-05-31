package com.example.backend.controller;


import com.example.backend.entity.PostEntity;
import com.example.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/naver-economy")
    public List<PostEntity> getNaverEconomyPosts() {
        return postRepository.findByCategory("네이버경제");
    }

    @GetMapping("/naver-game")
    public List<PostEntity> getNaverGamePosts() {
        return postRepository.findByCategory("네이버게임");
    }

    @GetMapping("/naver-sports")
    public List<PostEntity> getNaverSportsPosts() {
        return postRepository.findByCategory("네이버스포츠");
    }

    @GetMapping("/naver-politics")
    public List<PostEntity> getNaverPoliticsPosts() {
        return postRepository.findByCategory("네이버정치");
    }

    @GetMapping("/youtube-shorts")
    public List<PostEntity> getYoutubeShortsPosts() {
        return postRepository.findByCategory("유튜브숏");
    }
    @GetMapping("/youtube-long")
    public List<PostEntity> getYoutubeLongPosts() {
        return postRepository.findByCategory("유튜브롱");
    }

    @GetMapping("/naver-economy/latest")
    public List<PostEntity> getLatestNaverEconomyPosts() {
        return postRepository.findByCategory("네이버경제", PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "date")));
    }

    @GetMapping("/naver-game/latest")
    public List<PostEntity> getLatestNaverGamePosts() {
        return postRepository.findByCategory("네이버게임", PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "date")));
    }

    @GetMapping("/naver-sports/latest")
    public List<PostEntity> getLatestNaverSportsPosts() {
        return postRepository.findByCategory("네이버스포츠", PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "date")));
    }

    @GetMapping("/naver-politics/latest")
    public List<PostEntity> getLatestNaverPoliticsPosts() {
        return postRepository.findByCategory("네이버정치", PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "date")));
    }

    @GetMapping("/youtube-shorts/latest")
    public List<PostEntity> getLatestYoutubeShortsPosts() {
        return postRepository.findByCategory("유튜브숏", PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "date")));
    }

    @GetMapping("/youtube-long/latest")
    public List<PostEntity> getLatestYoutubeLongPosts() {
        return postRepository.findByCategory("유튜브롱", PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "date")));
    }

}