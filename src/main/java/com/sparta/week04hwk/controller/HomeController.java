package com.sparta.week04hwk.controller;

import com.sparta.week04hwk.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // 로그인한 유저가 userDetails 가지고 home 가는 컨트롤러
    @GetMapping("/pass")
    public String home_pass(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null)
            model.addAttribute("username", userDetails.getUsername());
        return "home";
    }
    // 로그인안한 유저가 home 가는 컨트롤러
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/templates/fail")
    public String fail() {
        return "fail";
    }



//    @GetMapping("/login/test")
//    public
//    @GetMapping("/api/contents/write")
//    public String write_page() {
//        return "write";
//    }
}