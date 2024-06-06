package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.sql.Date;

@Entity
@Table(name = "comments")
public class CommentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pid", nullable = false)
    private PostEntity post;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uid", nullable = false)
    private UserEntity user;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "date")
    private Date date;

    // Getters and Setters

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
