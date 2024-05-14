package com.example.backend.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "likes")
public class LikesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lid;

    @Column(name = "likedate")
    @Temporal(TemporalType.DATE)
    private Date likedate;

    @ManyToOne
    @JoinColumn(name = "pid", nullable = false)
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "uid", nullable = false)
    private UserEntity user;

    // Getters and Setters
}