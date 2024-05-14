package com.example.backend.repository;

import com.example.backend.entity.LikesEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikesRepository extends JpaRepository<LikesEntity, Integer> {
    @EntityGraph(attributePaths = {"post", "user"})
    List<LikesEntity> findAll();
}
