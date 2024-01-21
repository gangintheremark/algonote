package com.algorithm.Algonote.controller;

import com.algorithm.Algonote.dto.UserCreateForm;
import com.algorithm.Algonote.model.MemberEntity;
import com.algorithm.Algonote.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

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

    @GetMapping("/withdraw")
    public String deletePage() {
        return "member/withdraw";
    }
    @PostMapping("/withdraw")
    public String deleteUser(HttpSession session, Principal principal) throws Exception {
        String memberId = principal.getName();
        Optional<MemberEntity> memberEntity = memberService.findMember(memberId);

        boolean res = memberService.deleteUser(memberEntity);
        if (res == true) {
            if (session != null) {
                session.invalidate();
            }
            return "redirect:/main";
        } else {
            return "member/delete";
        }
    }

}
