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

    public Date getLikedate() {
        return likedate;
    }

    public int getLid() {
        return lid;
    }

    public PostEntity getPost() {
        return post;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setLikedate(Date likedate) {
        this.likedate = likedate;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    // Getters and Setters
}