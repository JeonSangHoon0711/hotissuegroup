package com.example.backend.repository;

import com.example.backend.entity.LikesEntity;
import com.example.backend.entity.PostEntity;
import com.example.backend.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<LikesEntity, Integer> {


    LikesEntity findByUserAndPost(UserEntity user, PostEntity post);

    Page<LikesEntity> findByUser_Uid(long uid, PageRequest likedate);
}
