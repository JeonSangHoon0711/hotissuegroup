package com.example.backend.controller;


import com.example.backend.entity.PostEntity;
import com.example.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    @GetMapping("/naver-economy")
    public List<PostEntity> getNaverEconomyPosts() {
        return postRepository.findByCategory("naver-economy", Sort.by(Sort.Direction.DESC, "date"));
    }

    @GetMapping("/naver-game")
    public List<PostEntity> getNaverGamePosts() {
        return postRepository.findByCategory("naver-game", Sort.by(Sort.Direction.DESC, "date"));
    }

    @GetMapping("/naver-sports")
    public List<PostEntity> getNaverSportsPosts() {
        return postRepository.findByCategory("naver-sports", Sort.by(Sort.Direction.DESC, "date"));
    }

    @GetMapping("/naver-politics")
    public List<PostEntity> getNaverPoliticsPosts() {
        return postRepository.findByCategory("naver-politics", Sort.by(Sort.Direction.DESC, "date"));
    }

    @GetMapping("/youtube-shorts")
    public List<PostEntity> getYoutubeShortsPosts() {
        return postRepository.findByCategory("youtube-shorts", Sort.by(Sort.Direction.DESC, "date"));
    }

    @GetMapping("/youtube-long")
    public List<PostEntity> getYoutubeLongPosts() {
        return postRepository.findByCategory("youtube-long", Sort.by(Sort.Direction.DESC, "date"));
    }
    @GetMapping("/naver-economy/latest")
    public Page<PostEntity> getLatestNaverEconomyPosts(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "date"));
        return postRepository.findByCategory("naver-economy", pageable);
    }

    @GetMapping("/naver-game/latest")
    public Page<PostEntity> getLatestNaverGamePosts(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "date"));
        return postRepository.findByCategory("naver-game", pageable);
    }

    @GetMapping("/naver-sports/latest")
    public Page<PostEntity> getLatestNaverSportsPosts(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "date"));
        return postRepository.findByCategory("naver-sports", pageable);
    }

    @GetMapping("/naver-politics/latest")
    public Page<PostEntity> getLatestNaverPoliticsPosts(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "date"));
        return postRepository.findByCategory("naver-politics", pageable);
    }

    @GetMapping("/youtube-shorts/latest")
    public Page<PostEntity> getLatestYoutubeShortsPosts(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "date"));
        return postRepository.findByCategory("youtube-shorts", pageable);
    }

    @GetMapping("/youtube-long/latest")
    public Page<PostEntity> getLatestYoutubeLongPosts(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "date"));
        return postRepository.findByCategory("youtube-long", pageable);
    }

    @GetMapping("/naver-economy/count")
    public long getNaverEconomyPostsCount() {
        return postRepository.countByCategory("naver-economy");
    }

    @GetMapping("/naver-game/count")
    public long getNaverGamePostsCount() {
        return postRepository.countByCategory("naver-game");
    }

    @GetMapping("/naver-sports/count")
    public long getNaverSportsPostsCount() {
        return postRepository.countByCategory("naver-sports");
    }

    @GetMapping("/naver-politics/count")
    public long getNaverPoliticsPostsCount() {
        return postRepository.countByCategory("naver-politics");
    }

    @GetMapping("/youtube-shorts/count")
    public long getYoutubeShortsPostsCount() {
        return postRepository.countByCategory("youtube-shorts");
    }

    @GetMapping("/youtube-long/count")
    public long getYoutubeLongPostsCount() {
        return postRepository.countByCategory("youtube-long");
    }



    // youtube-shorts에 대한 메소드
    @GetMapping("/youtube-shorts/{page}")
    public List<PostEntity> getYoutubeShortsPage(@PathVariable int page) {
        Page<PostEntity> postPage = postRepository.findByCategory(
                "youtube-shorts",
                PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "pid"))
        );
            return postPage.getContent();

    }
    // 유튜브 롱폼
    @GetMapping("/youtube-long/{page}")
    public List<PostEntity> getYoutubeLongPage(@PathVariable int page) {
        Page<PostEntity> postPage = postRepository.findByCategory(
                "youtube-long",
                PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "pid"))
        );
        return postPage.getContent();
    }

    // 네이버 뉴스 (정치)
    @GetMapping("/naver-politics/{page}")
    public List<PostEntity> getNaverPoliticsPage(@PathVariable int page) {
        Page<PostEntity> postPage = postRepository.findByCategory(
                "naver-politics",
                PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "pid"))
        );
        return postPage.getContent();
    }

    // 네이버 뉴스 (경제)
    @GetMapping("/naver-economy/{page}")
    public List<PostEntity> getNaverEconomyPage(@PathVariable int page) {
        Page<PostEntity> postPage = postRepository.findByCategory(
                "naver-economy",
                PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "pid"))
        );
        return postPage.getContent();
    }

    // 네이버 뉴스 (스포츠)
    @GetMapping("/naver-sports/{page}")
    public List<PostEntity> getNaverSportsPage(@PathVariable int page) {
        Page<PostEntity> postPage = postRepository.findByCategory(
                "naver-sports",
                PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "pid"))
        );
        return postPage.getContent();
    }

    // 네이버 뉴스 (게임)
    @GetMapping("/naver-game/{page}")
    public List<PostEntity> getNaverGamePage(@PathVariable int page) {
        Page<PostEntity> postPage = postRepository.findByCategory(
                "naver-game",
                PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "date"))
        );
        return postPage.getContent();
    }


}