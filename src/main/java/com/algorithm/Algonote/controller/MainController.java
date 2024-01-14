package com.algorithm.Algonote.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    @RequestMapping("/main")
    public String goMain() {
        return "main";
    }

    @RequestMapping("/member/signup")
    public String memberForm() {
        return "member/signup";
    }

    @RequestMapping("/loginForm")
    public String loginForm() {
        return "member/login";
    }

    @RequestMapping("/registForm")
    public String registForm() {
        return "problem/registration";
    }

    @RequestMapping("/introduce")
    public String introduce() {
        return "introduce";
    }
}
