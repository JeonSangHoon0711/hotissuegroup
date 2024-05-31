package com.example.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "search")
public class SearchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    private String title;

    @Column(name = "date")
    private LocalDateTime date; // LocalDate에서 LocalDateTime으로 변경

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSid() {
        return sid;
    }

    public LocalDateTime getDate() { // LocalDate에서 LocalDateTime으로 변경
        return date;
    }

    public String getTitle() {
        return title;
    }
}
