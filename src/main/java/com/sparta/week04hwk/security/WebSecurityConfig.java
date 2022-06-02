package com.sparta.week04hwk.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encodePassword() {

        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        // h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 회원 관리 처리 API (POST /user/**) 에 대해 CSRF 무시
//        http.csrf()
//                .ignoringAntMatchers("/member/**");
        http.csrf().disable();

        http.authorizeRequests()
                // image 폴더를 login 없이 허용
//                .antMatchers("/images/**").permitAll()
//                // css 폴더를 login 없이 허용
//                .antMatchers("/css/**").permitAll()
//                // 회원 관리 처리 API 전부를 login 없이 허용
//                .antMatchers("/member/**").permitAll()
//                .antMatchers("/templates/**").permitAll()
//                .antMatchers("/api/contents**","/api/contents/detail/**").permitAll()
//                 모든 요청, 모든 사용자에게 인증을 요구한다.
//                .anyRequest().authenticated()
                .antMatchers("/api/reply/**").authenticated()
                .antMatchers("/api/contents/content").authenticated() // 특정 요청 인증요구
                .anyRequest().permitAll()

                .and()
                    // 로그인 기능 허용
                    .formLogin()
                    // 로그인 성공시
                    .defaultSuccessUrl("/pass")
                    .failureUrl("/login")
                    .permitAll()
                .and()
                // 로그아웃 기능 허용
                //로그아웃을 하면 세션을 지워버립니다.
                .logout().logoutUrl("/logout").invalidateHttpSession(true)
                .permitAll();
    }
}