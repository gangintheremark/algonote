package com.algorithm.Algonote.service;

import com.algorithm.Algonote.model.ProblemEntity;
import com.algorithm.Algonote.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProblemService {
    private final ProblemRepository problemRepository;

    public void addProblem(ProblemEntity request) {
        problemRepository.save(request);
    }
}
