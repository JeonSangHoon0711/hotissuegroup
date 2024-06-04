package com.example.backend.repository;

import com.example.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByName(String name);
    boolean existsById(String id);
    boolean existsByEmail(String email);
    Optional<UserEntity> findById(String id); // String 타입의 ID를 처리할 수 있는 findById 선언
}