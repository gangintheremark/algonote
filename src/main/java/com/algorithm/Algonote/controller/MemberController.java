package com.algorithm.Algonote.controller;

import com.algorithm.Algonote.model.UserCreateForm;
import com.algorithm.Algonote.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {
    private  final MemberService memberService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm){
        return "member/join";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("error");
            return "member/join";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                "2개의 패스워드가 일치하지 않습니다.");
            return "member/join";
        }
        memberService.create(userCreateForm.getMemberId(),
            userCreateForm.getEmail1()+"@"+userCreateForm.getEmail2(), userCreateForm.getPassword1(),userCreateForm.getNickname());

        return "redirect:/main";
    }

    @GetMapping("/login")
    public String login(){
        return "member/login";
    }

}
