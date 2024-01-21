package com.algorithm.Algonote.controller;

import com.algorithm.Algonote.model.ProblemEntity;
import com.algorithm.Algonote.service.ProblemService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProblemController {

	private final ProblemService problemService;

	@GetMapping("/problem")
	public String problem(HttpSession session, Model m, Principal principal) {
		if(principal == null) {
			return "member/login";
		}
		String memberId = principal.getName();
		List<ProblemEntity> problems = problemService.findProblems(memberId);
		m.addAttribute("problems", problems);

		return "problem/myProblem";
	}

	@RequestMapping("/problemInfo")
	public String problemInfo(@RequestParam("problemNum") int problemNum, Model m) {
		ProblemEntity problem = problemService.findProblem(problemNum);
		m.addAttribute("problem", problem);

		return "problem/problemInfo";
	}

	@RequestMapping("/mySuccess")
	public String success(HttpSession session, Model m, Principal principal) {
		String memberId = principal.getName();
		List<ProblemEntity> problems = problemService.findSolved(memberId, "Success");
		m.addAttribute("problems", problems);
		return "problem/mySuccess";
	}

	@RequestMapping("/myReferenced")
	public String referenced(HttpSession session, Model m, Principal principal) {
		String memberId = principal.getName();
		List<ProblemEntity> problems = problemService.findSolved(memberId, "Referenced");
		m.addAttribute("problems", problems);
		return "problem/myReferenced";
	}

	@RequestMapping("/categoryList")
	public String category(HttpSession session, Model m) {
		// 로그인 인터셉터
		List<String> categories = Arrays.asList("DFS", "BFS", "재귀", "DP", "Dijkstra", "기타");
		m.addAttribute("categories", categories);

		return "problem/problemList";
	}

	@GetMapping("/category")
	public String findByCategory(HttpSession session, Model m, Principal principal,
			@RequestParam(name = "category", defaultValue = "기타") String category) {
		String memberId = principal.getName();
		List<ProblemEntity> problems = problemService.findCategory(memberId, category);
		m.addAttribute("problems", problems);

		return "problem/typeOfProblem";
	}
}