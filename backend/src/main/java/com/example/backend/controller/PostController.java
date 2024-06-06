package com.example.backend.controller;


import com.example.backend.dto.PostsRequestDto;
import com.example.backend.entity.PostEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.repository.PostRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }
    @GetMapping("/naver-economy")
    public List<PostEntity> getNaverEconomyPosts() {
        return postRepository.findByCategory("naver-economy", Sort.by(Sort.Direction.DESC, "pid"));
    }

    @GetMapping("/naver-game")
    public List<PostEntity> getNaverGamePosts() {
        return postRepository.findByCategory("naver-game", Sort.by(Sort.Direction.DESC, "pid"));
    }

    @GetMapping("/naver-sports")
    public List<PostEntity> getNaverSportsPosts() {
        return postRepository.findByCategory("naver-sports", Sort.by(Sort.Direction.DESC, "pid"));
    }

    @GetMapping("/naver-politics")
    public List<PostEntity> getNaverPoliticsPosts() {
        return postRepository.findByCategory("naver-politics", Sort.by(Sort.Direction.DESC, "pid"));
    }

    @GetMapping("/youtube-shorts")
    public List<PostEntity> getYoutubeShortsPosts() {
        return postRepository.findByCategory("youtube-shorts", Sort.by(Sort.Direction.DESC, "pid"));
    }

    @GetMapping("/youtube-long")
    public List<PostEntity> getYoutubeLongPosts() {
        return postRepository.findByCategory("youtube-long", Sort.by(Sort.Direction.DESC, "pid"));
    }
    @GetMapping("/naver-economy/latest")
    public Page<PostEntity> getLatestNaverEconomyPosts(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "pid"));
        return postRepository.findByCategory("naver-economy", pageable);
    }

    @GetMapping("/naver-game/latest")
    public Page<PostEntity> getLatestNaverGamePosts(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "pid"));
        return postRepository.findByCategory("naver-game", pageable);
    }

    @GetMapping("/naver-sports/latest")
    public Page<PostEntity> getLatestNaverSportsPosts(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "pid"));
        return postRepository.findByCategory("naver-sports", pageable);
    }

    @GetMapping("/naver-politics/latest")
    public Page<PostEntity> getLatestNaverPoliticsPosts(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "pid"));
        return postRepository.findByCategory("naver-politics", pageable);
    }

    @GetMapping("/youtube-shorts/latest")
    public Page<PostEntity> getLatestYoutubeShortsPosts(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "pid"));
        return postRepository.findByCategory("youtube-shorts", pageable);
    }

    @GetMapping("/youtube-long/latest")
    public Page<PostEntity> getLatestYoutubeLongPosts(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "pid"));
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
                PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "pid"))
        );
        return postPage.getContent();
    }
    @GetMapping("/community/{page}")
    public List<PostEntity> getCommunityePage(@PathVariable int page) {
        Page<PostEntity> postPage = postRepository.findByCategory(
                "community",
                PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "pid"))
        );
        return postPage.getContent();
    }



    @GetMapping("/{pid}")
    public PostEntity getPost(@PathVariable int pid) {
        return postRepository.findById(pid).orElse(null);
    }

    @GetMapping("/search/{title}/{page}")
    public List<PostEntity> searchPosts(@PathVariable String title, @PathVariable int page) {
        Page<PostEntity> postPage = postRepository.findByTitleContaining(
                title,
                PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "pid"))
        );
        return postPage.getContent();
    }

    @PostMapping("/write")
    public ResponseEntity<?> createPost(@RequestBody PostsRequestDto postRequest) {
        Optional<UserEntity> userOptional = userRepository.findById(postRequest.getUid());

        if (!userOptional.isPresent()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        UserEntity user = userOptional.get();

        PostEntity post = new PostEntity();
        post.setUser(user);
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());

        // String으로 된 날짜를 Date 객체로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.parse(postRequest.getDate(), formatter);
        Date date = Date.valueOf(localDateTime.toLocalDate());

        post.setDate(date);
        post.setCategory(postRequest.getCategory());

        postRepository.save(post);

        return ResponseEntity.ok("Post created successfully");
    }

    ///search postmapping

    public static class SearchRequest {
        private String title;
        private int page;

        public String getTitle() {
            return title;
        }

        public int getPage() {
            return page;
        }

        // getter와 setter 생략
    }
    @PostMapping("/search")
    public List<PostEntity> searchPosts(@RequestBody SearchRequest searchRequest) {
        Page<PostEntity> postPage = postRepository.findByTitleContaining(
                searchRequest.getTitle(),
                PageRequest.of(searchRequest.getPage() - 1, 5, Sort.by(Sort.Direction.DESC, "pid"))
        );
        return postPage.getContent();
    }


}