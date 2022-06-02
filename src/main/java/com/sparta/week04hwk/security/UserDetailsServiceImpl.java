package com.sparta.week04hwk.security;

import com.sparta.week04hwk.model.Member;
import com.sparta.week04hwk.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

// UserDetailsService인터페이스를 가져다 쓰니까 메소드는 반듯이 구현해야 하는 메소드
// load User By Username 이름만 봐도 유저에서 유저네임을 가져온다는거같다.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// 접속을 시도한 username이 DB에 저장되어 있다면 그 행을 가져다 member에 넣어준다
// 찾아봤는데 없다면 "Cant~~ " 문구가 실행된다.
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + username));
// UserDetailsImpl 클래스에 있는 멤버변수 member에 접속을 시도한 member의 정보를 넘겨준다.
        return new UserDetailsImpl(member);
    }
}