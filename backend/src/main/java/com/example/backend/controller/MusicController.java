package com.example.backend.controller;

import com.example.backend.entity.MusicEntity;
import com.example.backend.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/music") // 이 경로로 요청이 오면 아래의 메소드들이 처리됩니다.
public class MusicController {

    private final MusicRepository musicRepository;

    @Autowired // MusicRepository를 자동으로 주입받습니다.
    public MusicController(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @GetMapping("/all") // GET 요청을 "/api/music/all" 경로로 받습니다.
    public List<MusicEntity> getAllMusic() {
        return musicRepository.findAll(); // 모든 음악 정보를 반환합니다.
    }

    @GetMapping("/latest") // GET 요청을 "/api/music/latest" 경로로 받습니다.
    public List<MusicEntity> getLatestMusic() {
        // PageRequest를 사용하여 마지막 100개의 데이터를 mid 기준으로 내림차순으로 가져옴
        PageRequest pageRequest = PageRequest.of(0, 100, Sort.by("mid").descending());
        List<MusicEntity> last100Music = musicRepository.findAll(pageRequest).getContent();

        // 마지막 100개 중에서 뒤의 10개 데이터를 추출하고 역순으로 정렬하여 반환
        List<MusicEntity> last10Music = last100Music.stream()
                .skip(Math.max(0, last100Music.size() - 10)) // 리스트의 끝에서 10개 데이터를 추출
                .collect(Collectors.toList());

        Collections.reverse(last10Music); // 역순으로 정렬

        return last10Music;
    }
}
