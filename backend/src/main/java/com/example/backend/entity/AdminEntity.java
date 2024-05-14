package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "user_uid", nullable = false)
    private Long userUid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User_uid", referencedColumnName = "uid", insertable = false, updatable = false)
    private UserEntity user;


    public AdminEntity() {
    }

    // adminId의 getter와 setter
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    // userUid의 getter와 setter
    public Long getUserUid() {
        return userUid;
    }

    public void setUserUid(Long userUid) {
        this.userUid = userUid;
    }

    // UserEntity와의 관계를 설정하는 getter와 setter
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}