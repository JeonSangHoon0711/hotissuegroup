package com.example.backend.controller;

import com.example.backend.entity.SearchEntity;
import com.example.backend.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchRepository searchRepository;

    // 모든 검색 엔티티를 가져오는 엔드포인트
    @GetMapping("/all")
    public List<SearchEntity> getAllSearchEntities() {
        return searchRepository.findAll();
    }

    // 최신 10개의 검색 엔티티를 가져오는 엔드포인트
    @GetMapping("/latest")
    public List<SearchEntity> getLatestSearchEntities() {
        // 최신 10개의 데이터를 sid 기준으로 내림차순으로 가져옴
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("sid").descending());
        List<SearchEntity> searchEntities = searchRepository.findTop10ByOrderBySidDesc(pageRequest);

        // 가져온 데이터를 역순으로 처리하여 오름차순으로 정렬
        Collections.reverse(searchEntities);

        return searchEntities;
    }

}
