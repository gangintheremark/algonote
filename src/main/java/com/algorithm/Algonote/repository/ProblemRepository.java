package com.algorithm.Algonote.repository;

import com.algorithm.Algonote.model.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProblemRepository  extends JpaRepository <ProblemEntity, Long> {
}
