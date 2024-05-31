package com.example.backend.repository;


import com.example.backend.entity.PostEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    List<PostEntity> findByCategory(String category);
    List<PostEntity> findByCategory(String category, Pageable pageable);
}