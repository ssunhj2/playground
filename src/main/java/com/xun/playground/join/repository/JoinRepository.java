package com.xun.playground.join.repository;

import com.xun.playground.join.entity.JoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 회원가입 Repository
 */
public interface JoinRepository extends JpaRepository<JoinEntity, String> {
    // 중복검사를 위해 login id 로 검색
    JoinEntity findByLoginId(String loginId);
}
