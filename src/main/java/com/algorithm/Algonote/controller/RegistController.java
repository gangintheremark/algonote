package com.algorithm.Algonote.controller;

import com.algorithm.Algonote.model.ProblemEntity;
import com.algorithm.Algonote.service.ProblemService;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class RegistController {

	private final ProblemService problemService;
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	@PostMapping("/problem")
	public String registProblem(ProblemEntity request, Principal principal) {
		String memberId = principal.getName();
		request.setUserid(memberId);
		problemService.addProblem(request);
		return "problem/success";
	}


	@RequestMapping("/goModify")
	public String goModify(@RequestParam("problemNum") int problemNum, Model m) {
		ProblemEntity problem = problemService.findProblem(problemNum);
		m.addAttribute("problem", problem);
		return "problem/reviseForm";
	}
	
	@PutMapping("/modify/{problemNum}")
	@ResponseBody
	public String modify(@PathVariable("problemNum") int problemNum, @RequestBody ProblemEntity request, Principal principal) {
		String memberId = principal.getName();
		problemService.modify(problemNum, memberId, request);
		return "수정되었습니다.";
	}
	
	@DeleteMapping("/delete/{problemNum}")
	@ResponseBody
	public String delete(@PathVariable("problemNum") int problemNum) {
		problemService.delete(problemNum);
		return "삭제되었습니다.";
	}
	
}
