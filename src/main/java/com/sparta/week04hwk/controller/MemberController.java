package com.sparta.week04hwk.controller;


import com.sparta.week04hwk.model.Member;
import com.sparta.week04hwk.dto.SignupRequestDto;
import com.sparta.week04hwk.repository.MemberRepository;
import com.sparta.week04hwk.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    // 회원DB보기
    @GetMapping("/member/signup")
    @ResponseBody
    public List<Member> readMember () {
        return memberRepository.findAll();
    }

    // 회원가입
    @Transactional
    @PostMapping("/member/signup")
    @ResponseBody
    public Member signUp (@RequestBody @Valid SignupRequestDto requestDto) {
        return memberService.signup(requestDto);
    }



}
