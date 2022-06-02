package com.sparta.week04hwk.dto;


import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


@Getter
public class SignupRequestDto {
    // 영문대,소문자로 시작 + 영어or숫자 + 최소 3자리 이상
    @Pattern(regexp = "[a-zA-Z]+[a-zA-Z0-9]{3,}", message = "에러메세지 아이디 3자리이상")
    private String username;
    @Pattern(regexp = "[a-zA-Z1-9]{4,}", message = "에러메세지 비밀번호 4자리이상")
    private String password;
    private String password1;
    private String email;

}
