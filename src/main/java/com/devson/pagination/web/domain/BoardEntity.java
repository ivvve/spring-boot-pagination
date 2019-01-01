package com.devson.pagination.web.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "BOARD")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity writer;

    @Builder
    public BoardEntity(String title, UserEntity writer) {
        this.title = title;
        this.writer = writer;
    }
}

