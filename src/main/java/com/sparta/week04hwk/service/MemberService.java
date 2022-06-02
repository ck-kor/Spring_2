package com.sparta.week04hwk.service;


import com.sparta.week04hwk.dto.SignupRequestDto;
import com.sparta.week04hwk.model.Member;
import com.sparta.week04hwk.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Transactional
    public Member signup(SignupRequestDto requestDto) {
        // 회원 ID 중복 확인
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String password1 = requestDto.getPassword1();
        Optional<Member> found = memberRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }
        // 비밀번호 아이디포함 확인
        if (requestDto.getPassword().contains(username)) {
            throw new IllegalArgumentException("비밀번호에 아이디가 포함됩니다.");
        }
        // 비밀번호 , 비밀번호확인 같은지 보기
        if (!password.equals(password1)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        // 패스워드 암호화
        password = passwordEncoder.encode(password);
        String email = requestDto.getEmail();

        Member member = new Member(username,password,email);

        return memberRepository.save(member);
    }
}
