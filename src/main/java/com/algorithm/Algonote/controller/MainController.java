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

    @RequestMapping("/memberForm")
    public String memberForm() {
        return "member/join";
    }

    @RequestMapping("/loginForm")
    public String loginForm() {
        return "member/login";
    }

    @RequestMapping("/registForm")
    public String registForm() {
        return "problem/registration";
    }

    @RequestMapping("/myProblem")
    public String myProblem() {
        return "problem/myProblem";
    }
}
