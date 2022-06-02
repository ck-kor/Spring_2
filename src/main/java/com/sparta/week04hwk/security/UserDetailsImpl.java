package com.sparta.week04hwk.security;

import com.sparta.week04hwk.model.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private final Member member;

    public UserDetailsImpl(Member member) {
        this.member = member;
    }

    public Member getMember() {
        return member;
    }
    // Authentication Manager 가 로그인을 시도한 ID, Password와 DB에 있는 ID, Password를 비교할 때 사용할 메소드
    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }
//계정이 만료되지 않았는지 리턴 false = 만료
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
// 계정이 잠겨있지 않은지 리턴 false = 잠김
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
// 계정의 패스워드가 만료되지 않았는지 리턴 false = 패스워드 만료
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
// 계정이 사용가능한 계정인지 리턴 false = 사용불가한 계정을 의미
    @Override
    public boolean isEnabled() {
        return true;
    }
// 계정이 갖고있는 권한 목록을 리턴한다.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
}