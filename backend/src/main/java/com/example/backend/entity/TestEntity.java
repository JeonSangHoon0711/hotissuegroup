package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "test1")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtest1") // 실제 데이터베이스의 열 이름
    private Long id; // 필드 이름 변경

    @Column(name = "data_column") // 실제 데이터베이스의 열 이름
    private String dataColumn; // 필드 이름 변경

    // Getter와 Setter 추가
    @JsonProperty("idtest1")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataColumn() {
        return dataColumn;
    }

    public void setDataColumn(String dataColumn) {
        this.dataColumn = dataColumn;
    }
}
