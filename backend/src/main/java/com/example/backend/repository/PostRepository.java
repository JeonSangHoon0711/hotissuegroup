package com.example.backend.repository;


import com.example.backend.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    List<PostEntity> findByCategory(String category);
   // List<PostEntity> findByCategory(String category, Pageable pageable);
    List<PostEntity> findByCategory(String category, Sort sort);
    long countByCategory(String category);
    //Page<PostEntity> findByCategorypage(String category, Pageable pageable);
    Page<PostEntity> findByCategory(String category, Pageable pageable);

    Page<PostEntity> findByTitleContaining(String title, PageRequest pid);

    List<PostEntity> findByTitleContaining(String title);
}