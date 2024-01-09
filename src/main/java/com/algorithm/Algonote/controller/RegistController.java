package com.algorithm.Algonote.controller;

import com.algorithm.Algonote.model.ProblemEntity;
import com.algorithm.Algonote.service.ProblemService;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class RegistController {

    ProblemService problemService;

    @GetMapping("/problem")
    public String registProblem(@RequestParam ProblemEntity request) {
            // 로그인 체크 인터셉터 추가 필요

            request.setCategory("DFS");
            request.setUserid("gang");
            problemService.addProblem(request);
            return "success";
    }
}
