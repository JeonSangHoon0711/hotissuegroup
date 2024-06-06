package com.example.backend.controller;

import com.example.backend.dto.CommentRequestDto;
import com.example.backend.dto.CommentResponseDto;
import com.example.backend.entity.CommentsEntity;
import com.example.backend.entity.PostEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.repository.CommentsRepository;
import com.example.backend.repository.PostRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get/{pid}")
    public List<CommentResponseDto> getComments(@PathVariable int pid) {
        List<CommentsEntity> commentEntities = commentsRepository.findByPost_Pid(pid);

        return commentEntities.stream().map(entity -> {
            CommentResponseDto dto = new CommentResponseDto();
            dto.setCid(entity.getCid());
            dto.setPid(entity.getPost().getPid());
            dto.setUid(entity.getUser().getUid().intValue());  // Long을 int로 변환
            dto.setUserName(entity.getUser().getName());
            dto.setDate(entity.getDate());
            dto.setContent(entity.getContent());
            return dto;
        }).collect(Collectors.toList());
    }
    @PostMapping("/write")
    public CommentsEntity addComment(@RequestBody CommentRequestDto commentRequestDto) {
        PostEntity post = postRepository.findById(commentRequestDto.getPid()).orElseThrow();
        UserEntity user = userRepository.findById(commentRequestDto.getUid()).orElseThrow();

        CommentsEntity comment = new CommentsEntity();
        comment.setPost(post);
        comment.setUser(user);
        comment.setDate(commentRequestDto.getDate());
        comment.setContent(commentRequestDto.getContent());

        return commentsRepository.save(comment);
    }
}
