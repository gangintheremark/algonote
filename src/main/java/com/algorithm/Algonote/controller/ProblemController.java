package com.algorithm.Algonote.controller;

import com.algorithm.Algonote.model.ProblemEntity;
import com.algorithm.Algonote.service.ProblemService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProblemController {

    private final ProblemService problemService;

    @GetMapping("/problem")
    public String problem(HttpSession session, Model m) {
        // 세션에서 로그인 유저 정보 가져오기
        String userid = "gang"; // [임시]

        List<ProblemEntity> problems = problemService.findProblems(userid);
        m.addAttribute("problems", problems);
        System.out.println("문제" + problems);
        return "problem/myProblem";
    }
}
