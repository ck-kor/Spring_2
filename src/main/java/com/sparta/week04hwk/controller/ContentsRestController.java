package com.sparta.week04hwk.controller;

import com.sparta.week04hwk.dto.ContentsRequestDto;
import com.sparta.week04hwk.model.Contents;
import com.sparta.week04hwk.repository.ContentsRepository;
import com.sparta.week04hwk.security.UserDetailsImpl;
import com.sparta.week04hwk.service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api") //  /api 생략
public class ContentsRestController {

    private final ContentsRepository ContentsRepository;
    private final ContentsService ContentsService;

    // 게시글 전체 조회
    @GetMapping("/contents")
    public List<Contents> getContents() {

        return ContentsRepository.findAllByOrderByCreatedAtDesc();
    }

    // 게시글 특정 조회
    @GetMapping("/contents/{id}")
    public Contents getContents(@PathVariable Long id) {
        Contents contents =  ContentsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("contentsId가 존재하지 않습니다."));
        if(contents.getCount() !=0){} // 댓글이 있다면 적어주기?
        return contents;
    }

    // 게시글 생성
    @Transactional
    @PostMapping("/contents/content")
    public Contents createContents(@RequestBody ContentsRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long memberId = userDetails.getMember().getId();
        Contents contents = new Contents(requestDto, memberId);
        return ContentsRepository.save(contents);
    }

//    // 게시글 수정
//    @PutMapping("/contents/{id}")
//    public Long updateContents(@PathVariable Long id, @RequestBody ContentsRequestDto requestDto) {
//        ContentsService.update(id, requestDto);
//        return id;
//    }
//    // 게시글 삭제
//    @DeleteMapping("/contents/{id}")
//    public Long deleteContents(@PathVariable Long id) {
//        ContentsRepository.deleteById(id);
//        return id;
//    }

}