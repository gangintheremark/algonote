package com.algorithm.Algonote.repository;

import com.algorithm.Algonote.model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
