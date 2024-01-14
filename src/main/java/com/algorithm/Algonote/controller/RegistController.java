package com.algorithm.Algonote.controller;

import com.algorithm.Algonote.model.ProblemEntity;
import com.algorithm.Algonote.service.ProblemService;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RegistController {

    private final ProblemService problemService;

    @PostMapping("/problem")
    public String registProblem(ProblemEntity request) {
            // 로그인 체크 인터셉터 추가 필요
            problemService.addProblem(request);
            return "problem/success";
    }
}
