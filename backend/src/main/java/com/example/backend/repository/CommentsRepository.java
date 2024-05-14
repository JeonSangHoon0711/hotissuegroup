package com.example.backend.repository;

import com.example.backend.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity, Integer> {
    // 필요한 추가적인 쿼리 메서드를 여기에 정의할 수 있습니다.
}