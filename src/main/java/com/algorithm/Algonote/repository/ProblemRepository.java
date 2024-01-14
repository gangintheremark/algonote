package com.algorithm.Algonote.repository;

import com.algorithm.Algonote.model.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProblemRepository  extends JpaRepository <ProblemEntity, Long> {
    List<ProblemEntity> findByUserid(String userid);
}
