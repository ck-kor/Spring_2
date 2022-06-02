package com.sparta.week04hwk.model;

import com.sparta.week04hwk.dto.ContentsRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
// get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Contents extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "contents_id")
    private Long id;

    // nullable = false 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private Long memberId;

    // 댓글 연관관계

    public Contents(String title, String name, String contents) {
        this.title = title;
        this.name = name;
        this.contents = contents;
    }

    // 게시글 생성
    public Contents(ContentsRequestDto requestDto, Long memberId) {
        this.memberId = memberId;
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
        this.count = 0;
    }

    // 게시글 수정
    public void update(ContentsRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
    }
}