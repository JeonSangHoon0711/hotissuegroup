package com.example.backend.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user") // 데이터베이스의 실제 테이블 이름으로 변경
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid") // 데이터베이스의 열 이름에 맞춰 수정
    private Long uid;

    @Column(name = "id") // 데이터베이스의 열 이름에 맞춰 수정
    private String id;

    @Column(name = "name") // 필요한 경우 수정
    private String name;

    @Column(name = "email") // 필요한 경우 수정
    private String email;

    @Column(name = "pw") // 데이터베이스 열 이름에 맞춰 수정, 예를 들어 'pw' 필드가 'password' 열에 매핑된다고 가정
    private String pw;

    // getters and setters
    // uid 필드의 getter와 setter
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    // id 필드의 getter와 setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // name 필드의 getter와 setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // email 필드의 getter와 setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // pw 필드의 getter와 setter
    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}