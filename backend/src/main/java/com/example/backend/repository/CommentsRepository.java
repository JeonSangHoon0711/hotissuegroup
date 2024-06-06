package com.example.backend.repository;

import com.example.backend.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity, Integer> {
    List<CommentsEntity> findByPost_Pid(int pid);
}
