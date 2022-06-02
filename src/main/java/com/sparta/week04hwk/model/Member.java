package com.sparta.week04hwk.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter
@NoArgsConstructor
@Entity
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "member_id")
    private Long id;
    @Column (nullable = false, unique = true)
    private String username; //중복불가 붙이기 +
    @Column (nullable = false)
    private String password;
    @Column (nullable = false)
    private String email;

    public Member(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
