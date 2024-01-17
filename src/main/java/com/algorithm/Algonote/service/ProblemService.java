package com.algorithm.Algonote.service;

import com.algorithm.Algonote.model.ProblemEntity;
import com.algorithm.Algonote.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProblemService {
	private final ProblemRepository problemRepository;

	public List<ProblemEntity> findProblems(String userid) {
		List<ProblemEntity> problems = problemRepository.findByUserid(userid);

		return problems;
	}

	public ProblemEntity findProblem(int problemNum) {
		ProblemEntity problem = problemRepository.findById(problemNum).orElseThrow();

		return problem;
	}

	public void addProblem(ProblemEntity request) {
		problemRepository.save(request);
	}

	public List<ProblemEntity> findSolved(String userid, String solved) {
		List<ProblemEntity> problems = problemRepository.findByUseridAndSolved(userid, solved);
		return problems;
	}

	public List<ProblemEntity> findCategory(String userid, String category) {
		List<ProblemEntity> problems = problemRepository.findByUseridAndCategory(userid, category);
		return problems;
	}

	public void modify(int problemNum, String userid, ProblemEntity request) {
		ProblemEntity problem = problemRepository.findById(problemNum).orElseThrow();
		problem.editProblem(userid, request.getTitle(), request.getText(), request.getCode(), request.getSolved(), request.getLanguage(), request.getCategory());
		problemRepository.save(problem);
	}
}