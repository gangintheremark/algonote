package com.algorithm.Algonote.repository;

import com.algorithm.Algonote.model.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProblemRepository  extends JpaRepository <ProblemEntity, Integer> {
    List<ProblemEntity> findByUserid(String userid);
    List<ProblemEntity> findByUseridAndSolved(String userid, String solved);
}