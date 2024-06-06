package com.example.backend.controller;

import com.example.backend.entity.LikesEntity;
import com.example.backend.entity.PostEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.repository.LikesRepository;
import com.example.backend.repository.PostRepository;
import com.example.backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/likes")
public class LikesController {

    private static final Logger logger = LoggerFactory.getLogger(LikesController.class);

    @Autowired
    private LikesRepository likesRepository;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    // 모든 좋아요 조회
    @GetMapping("/all")
    public List<LikesEntity> getAllLikes() {
        return likesRepository.findAll();
    }

    @GetMapping("/{uid}/{pid}")
    public ResponseEntity<String> getLike(@PathVariable int uid, @PathVariable int pid) {
        Optional<PostEntity> post = postRepository.findById(pid);
        Optional<UserEntity> user = userRepository.findById((long) uid);

        // post 또는 user가 없는 경우
        if (post.isEmpty() || user.isEmpty()) {
            return ResponseEntity.ok("no"); // 상태 코드 변경 없이 "no"만 리턴
        }

        LikesEntity like = likesRepository.findByUserAndPost(user.get(), post.get());

        // like가 없는 경우
        if (like == null) {
            return ResponseEntity.ok("no"); // 상태 코드 변경 없이 "no"만 리턴
        }

        // like가 있는 경우
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/add/{uid}/{pid}")
    public ResponseEntity<?> addLike(@PathVariable int uid, @PathVariable int pid) {
        try {
            PostEntity post = postRepository.findById(pid).orElseThrow(() -> new EntityNotFoundException("Post not found with id " + pid));
            UserEntity user = userRepository.findById((long) uid).orElseThrow(() -> new EntityNotFoundException("User not found with id " + uid));

            LikesEntity newLike = new LikesEntity(); // 새로운 LikesEntity 인스턴스를 생성합니다.
            newLike.setPost(post); // LikesEntity에 PostEntity를 설정합니다.
            newLike.setUser(user); // LikesEntity에 UserEntity를 설정합니다.
            newLike.setLikedate(new java.util.Date());
            likesRepository.save(newLike);
            System.out.println("newLike : " + newLike);
            // 북마크 추가가 성공했을 때 200 OK 상태 코드와 메시지를 반환
            return ResponseEntity.ok("ok");
        } catch (EntityNotFoundException e) {
            // 엔티티를 찾을 수 없을 때 404 Not Found 상태 코드와 메시지를 반환
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // 기타 예외가 발생했을 때 500 Internal Server Error 상태 코드와 메시지를 반환
            return ResponseEntity.internalServerError().body("북마크 추가에 실패했습니다.");
        }
    }

    @DeleteMapping("/delete/{uid}/{pid}")
    public ResponseEntity<?> deleteLike(@PathVariable int uid, @PathVariable int pid) {
        try {
            PostEntity post = postRepository.findById(pid).orElseThrow(() -> new EntityNotFoundException("Post not found with id " + pid));
            UserEntity user = userRepository.findById((long) uid).orElseThrow(() -> new EntityNotFoundException("User not found with id " + uid));

            LikesEntity like = likesRepository.findByUserAndPost(user, post);
            likesRepository.delete(like);
            // 북마크 삭제가 성공했을 때 200 OK 상태 코드와 메시지를 반환
            return ResponseEntity.ok("ok");
        } catch (EntityNotFoundException e) {
            // 엔티티를 찾을 수 없을 때 404 Not Found 상태 코드와 메시지를 반환
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // 기타 예외가 발생했을 때 500 Internal Server Error 상태 코드와 메시지를 반환
            return ResponseEntity.internalServerError().body("북마크 삭제에 실패했습니다.");
        }
    }

    @GetMapping("/bookmark/{page}/{uid}")
    public List<PostEntity> getBookmarkPage(@PathVariable int page, @PathVariable int uid) {
        Page<LikesEntity> likesPage = likesRepository.findByUser_Uid((long) uid, PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "likedate")));
        return likesPage.map(LikesEntity::getPost).getContent();
    }





}


