package com.sparta.week04hwk.model;

import com.sparta.week04hwk.dto.ReplyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Reply extends Timestamped{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 댓글 id

    private String name; // 댓글 쓴 이름

    private String reply; // 댓글 내용적는 곳

    private Long contentsNo; // 게시글 번호 > 해당 게시글 밑에 댓글 조회




    public Reply(Long id, ReplyRequestDto requestDto, String memberName) {
        this.contentsNo = id;
        this.name = memberName;
        this.reply = requestDto.getReply();
    }


    public void update(String updateReply) {
        this.reply = updateReply;
    }
}
