package com.algorithm.Algonote.repository;

import com.algorithm.Algonote.model.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<ProblemEntity, Long> {
}
