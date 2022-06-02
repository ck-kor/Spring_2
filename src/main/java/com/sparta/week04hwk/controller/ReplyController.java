package com.sparta.week04hwk.controller;


import com.sparta.week04hwk.dto.ReplyDeleteDto;
import com.sparta.week04hwk.dto.ReplyRequestDto;
import com.sparta.week04hwk.dto.ReplyUpdateDto;
import com.sparta.week04hwk.model.Reply;
import com.sparta.week04hwk.security.UserDetailsImpl;
import com.sparta.week04hwk.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api") // /api 생략 > 요청할 떈 써줘야됨
public class ReplyController {

    private final ReplyService replyService;

    // 댓글 조회
    @GetMapping("/reple/{id}")
    public List<Reply> readReply(@PathVariable Long id) {
        return replyService.read(id);
    }

    // 댓글 생성
    @PostMapping("/reply/{id}")
    public Reply createReply(@PathVariable Long id, @RequestBody ReplyRequestDto requestDto,
                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return replyService.save(id,requestDto,userDetails);
    }

    //댓글 수정
    @PutMapping("/reply/{id}")
    public Reply updateReply(@PathVariable Long id, @RequestBody ReplyUpdateDto requestDto ,
                              @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return replyService.update(id, requestDto, userDetails);
    }

//    댓글 삭제
    @DeleteMapping("/reply/{id}")
    public void removeReply(@PathVariable Long id, @RequestBody ReplyDeleteDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        replyService.delete(id, requestDto, userDetails);
    }
}
