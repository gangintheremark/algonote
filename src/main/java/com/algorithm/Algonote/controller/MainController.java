package com.algorithm.Algonote.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.security.Principal;

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

    @RequestMapping("/member/login")
    public String loginForm() {
        return "member/login";
    }

    @RequestMapping("/registForm")
    public String registForm(Principal principal) {
		if(principal == null) {
			return "member/login";
		}
        return "problem/registration";
    }

    @RequestMapping("/introduce")
    public String introduce() {
        return "introduce";
    }
}
