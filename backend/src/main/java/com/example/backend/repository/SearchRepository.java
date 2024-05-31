package com.example.backend.repository;

import com.example.backend.entity.SearchEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchRepository extends JpaRepository<SearchEntity, Long> {
    List<SearchEntity> findTop10ByOrderBySidDesc(Pageable pageable);
}