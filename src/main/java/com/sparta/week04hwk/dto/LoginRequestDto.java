package com.sparta.week04hwk.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDto {
    private String username;
    private String password;
    private String email;
    private String adminToken = "";
}