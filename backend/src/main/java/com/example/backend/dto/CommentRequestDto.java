package com.example.backend.dto;

public class CommentRequestDto {
    private int pid;
    private int uid;
    private java.sql.Date date;
    private String content;

    // Getters and Setters
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
