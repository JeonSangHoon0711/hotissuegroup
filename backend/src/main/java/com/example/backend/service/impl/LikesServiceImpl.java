package com.example.backend.service.impl;

import com.example.backend.entity.LikesEntity;
import com.example.backend.repository.LikesRepository;
import com.example.backend.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LikesServiceImpl implements LikesService {

    private static final Logger logger = LoggerFactory.getLogger(LikesServiceImpl.class);

    private final LikesRepository likesRepository;
    @Autowired
    public LikesServiceImpl(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

    @Override
    public List<LikesEntity> getAllLikes() {
        return likesRepository.findAll();
    }

}
